package leetcode.test;

public class SessionHandler {

    public  ThreadLocal<Session> session = ThreadLocal.withInitial(() -> new Session());
    public  ThreadLocal<StringBuffer> buuf = ThreadLocal.withInitial(() -> new StringBuffer());

    public static class Session {
        private String id;
        private String user;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public String getUser() {
        return session.get().getUser();
    }

    public String getStatus() {
        return session.get().getStatus();
    }

    public void buff(int count) {
        if(buuf != null) {
            buuf.get().append(count);
        }
    }
    public void buffnull() {
        buuf = null;
    }
    public void sout() {
        if(buuf != null){
            System.out.println(( Thread.currentThread() + ":" +buuf.get().toString()));
        }
    }
    public String getbuff() {
        return buuf.get().toString();
    }

    public void setStatus(String status) {
        session.get().setStatus(status);
    }

    public static void main(String[] args) {
//        new Thread(() -> {
//            SessionHandler handler = new SessionHandler();
//            handler.getStatus();
//            handler.getUser();
//            handler.setStatus("close");
//            handler.buff();
//            handler.getbuff();
//            handler.getStatus();
//        }).start();
        new Thread(() -> {
            SessionHandler handler = new SessionHandler();
            for (int i = 0;i<10;i++){
                handler.buff(1);
            }
            handler.sout();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            handler.buffnull();
            for (int i = 0;i<10;i++){
                handler.buff(1);
            }
            handler.sout();
        }).start();
        new Thread(() -> {
            SessionHandler handler = new SessionHandler();
            for (int i = 0;i<10;i++){
                handler.buff(1);
            }
            handler.sout();
            for (int i = 0;i<10;i++){
                handler.buff(1);
            }
            handler.sout();
        }).start();
    }
}