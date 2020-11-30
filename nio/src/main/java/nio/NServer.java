package nio;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;

public class NServer {
    public static final String REGEX = "#";
    // 用于检测所有Channel状态的Selector
    private Selector selector = null;
    // 定义实现编码、解码的字符集对象
    private Charset charset = Charset.forName("UTF-8");
    private int sleepTime = 10 * 1000;

    public void init() throws IOException, InterruptedException {
        selector = Selector.open();
        // 通过open方法来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 30000);
        // 将该ServerSocketChannel绑定到指定ip地址
        server.bind(isa);
        // 设置ServerSocket以非阻塞方式工作
        server.configureBlocking(false);
        // 将server注册到指定Selector对象,并绑定连接事件
        server.register(selector, SelectionKey.OP_ACCEPT);
        dealEvent(server);
    }

    private void dealEvent(ServerSocketChannel server) throws IOException {
        // 阻塞到只少有一个通道在之前准备的事件上就绪了
        while (selector.select() > 0) {
            // 依次处理selector上的每个已选择的SelectionKey
            for (SelectionKey sk : selector.selectedKeys()) {
                // 从selector上的已选择Key集中删除正在处理的SelectionKey
                selector.selectedKeys().remove(sk);
                // 如果sk对用的channel已经连接就绪
                if (sk.isAcceptable()) {
                    // 调用accept方法接受连接，产生的socketCahnnel（1）则与其请求连接的
                    // socketChannel（一）对应，可以通过channel（1）用于channel（一）进行通信
                    // accept方法只能由serverSocketChannel调用
                    SocketChannel sc = server.accept();
                    // 设置采用非阻塞模式，后才能注册selector
                    sc.configureBlocking(false);
                    // 将该才获得到的socketChannel（1）向selector注册可读事件，用于通信
                    sc.register(selector, SelectionKey.OP_READ);
                    // 将sk对应的Channel设置成准备接受其他请求
                    //                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                // 如果sk对应的通道有数据需要读取
                if (sk.isReadable()) {
                    // 获取该SelectionKey对应的Channel，该Channel中有可读的数据
                    SocketChannel sc = (SocketChannel) sk.channel();

                    // 定义准备之星读取数据的ByteBuffer
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    StringBuilder content = new StringBuilder();
                    // 开始读取数据
                    try {
                        while (sc.read(buff) > 0) {
                            buff.flip();
                            content.append(charset.decode(buff));
                        }
                        // 打印从该sk对应的Channel里读到的数据
                        //            System.out.println("==========" + content);
                        // 将此键的兴趣设置为给定值 如果一直接受读就绪就不用设置了，
                        // 要是读后再写想监听写就绪就要设置
                        //                        sk.interestOps(SelectionKey.OP_READ);

                        // 如果捕捉到该sk对应的channel出现异常，即表明该channel对应的client出现了
                        // 异常，所以从selector中取消sk的注册
                    } catch (IOException e) {
                        // 从Selector中删除指定的SelectionKey
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                    }
                    // 如果content的长度大于0，即聊天信息不为空
                    if (content.length() > 0) {
                        //            System.out.println("服务端接受到信息");
                        String[] contents = content.toString().split(REGEX);
                        // 遍历该selector里注册的所有SelectKey
                        for (SelectionKey key : selector.keys()) {
                            // 选取该key对应的Channel
                            Channel targetChannel = key.channel();
                            if ("pic".equals(contents[0])) {
                                new PictureThread((SocketChannel) targetChannel).start();
                                break;
                                //
                            }
                            if ("changTime".equals(contents[0]) && contents.length > 1) {
                                sleepTime = Integer.parseInt(contents[1]);
                                break;
                            }
							if ("end".equals(contents[0])) {
								System.exit(0);
								break;
							}
                            //
                            // 如果该channel是SocketChannel对象
                            //              if (targetChannel instanceof SocketChannel) {
                            //                // 将独到的内容写入该Channel中
                            //                SocketChannel dest = (SocketChannel) targetChannel;
                            //                dest.write(charset.encode(content));
                            //              }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //        new Thread(()->{
        //            try {
        //                Thread.sleep(1000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            try {
        //                new NClient().init();
        //            } catch (IOException e) {
        //                e.printStackTrace();
        //            }
        //
        //        }).start();SocketChannel

        try {
            new NServer().init();
        } catch (InterruptedException e) {
			// e.printStackTrace();
        }
    }

    private String fileName;
    private String defaultName = "GuiCamera";
    private String imageFormat; // 图像文件的格式
    private String defaultImageFormat = "jpg";
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    public ByteBuffer snapshot() {
        try {
            // 拷贝屏幕到一个BufferedImage对象screenshot
            BufferedImage screenshot =
                    (new Robot())
                            .createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(), (int) d.getHeight()));
            // 根据文件前缀变量和文件格式变量，自动生成文件名
            //      byte[] pixelData = ((DataBufferByte)
            // screenshot.getRaster().getDataBuffer()).getData();
            //      //        return ByteBuffer.wrap(pixelData);
            //      ByteBuffer buf = ByteBuffer.allocateDirect(pixelData.length);
            //      buf.order(ByteOrder.nativeOrder());
            //      buf.put(pixelData);
            //      buf.flip();
            return convertImageData(screenshot);
            // 将screenshot对象写入图像文件
            //          ImageIO.write(screenshot, imageFormat, f);

        } catch (Exception e) {
            //      System.out.println(e);
        }
        return null;
    }

    public static ByteBuffer convertImageData(BufferedImage bi) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpg", out);
            return ByteBuffer.wrap(out.toByteArray());
        } catch (IOException ex) {
            // TODO
        }
        return null;
    }

    // 定义读取服务器数据的线程
    private class PictureThread extends Thread {
        SocketChannel channel;

        public PictureThread(SocketChannel channel) {
            this.channel = channel;
        }

        public void run() {
            while (channel.isConnected()) {
                try {
                    channel.write(snapshot());
                    Thread.sleep(sleepTime);
                } catch (IOException | InterruptedException e) {
					// e.printStackTrace();
                }
            }
        }
    }
}
