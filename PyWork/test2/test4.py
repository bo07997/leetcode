import http.client
from git import Git

def get_webservertime(host):
    conn = http.client.HTTPConnection(host)
    conn.request("GET", "/")
    r=conn.getresponse()
    ts=r.getheader('date')
    r = Git("E:\\vstsworkspace\\projectXS")
    r.execute('git commit --amend --no-verify --date="'+ts+'"')
    r.execute("git log")
    print("test")


if __name__ == "__main__":
    get_webservertime('www.baidu.com')