
import socket
import struct
import time
import win32api
import subprocess
import os
import sys


def gettime(ntpserver_ips):
    TIME_1970 = 2208988800
    client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    client.settimeout(3)
    data = ('\x1b' + 47 * '\0').encode()
    Port = 123

    for server in ntpserver_ips:
        success = False
        count = 1
        '''Ã¿¸öip³¢ÊÔ3´Î'''
        while not success and count < 4:
            try:
                client.sendto(data, (server, Port))
                data = client.recvfrom(1024)[0]
                success = True
                print(server + ' get time success, tried ' + str(count) + ' times.')
            except socket.timeout:
                print(server + ' get time failed, tried ' + str(count) + ' times.')
                count += 1
        if success == True:
            break

    data_result = struct.unpack('!12I', data)[10]
    data_result -= TIME_1970
    return data_result


def settime(nowtime):
    tm_year, tm_mon, tm_mday, tm_hour, tm_min, tm_sec, tm_wday, tm_yday, tm_isdst = time.gmtime(nowtime)
    win32api.SetSystemTime(tm_year, tm_mon, tm_wday, tm_mday, tm_hour, tm_min, tm_sec, 0)
    # print(u'Set system time success.')


def getip_with_domains(ntpserver_domains):
    ips = []
    for i in ntpserver_domains:
        ip = socket.gethostbyname_ex(i)[2]
        ips.extend(ip)
    return ips


def get_webservertime(host):
    conn=http.client.HTTPConnection(host)
    conn.request("GET", "/")
    r=conn.getresponse()
    ts=  r.getheader('date')
    r = Git("E:\\vstsworkspace\\projectXS")
    r.execute('git commit --amend --no-verify --date="'+ts+'"')


if __name__ == '__main__':
    ntpserver_domains = ['cn.pool.ntp.org', 'ntp.sjtu.edu.cn', 'time.windows.com']
    ntpserver_ips = getip_with_domains(ntpserver_domains)
    save_old_time()
    if not ntpserver_ips:
        print(u'Some domain can not resolve ip.')
        os.system('pause')
        sys.exit()
    else:
        nowtime = gettime(ntpserver_ips)
        settime(nowtime)
        print('Now Time:', time.strftime('%Y-%m-%d %X'))
        sys.exit()
