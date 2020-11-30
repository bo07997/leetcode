

import time
import win32api
import sys


def settime(nowtime):
    tm_year, tm_mon, tm_mday, tm_hour, tm_min, tm_sec, tm_wday, tm_yday, tm_isdst = time.gmtime(nowtime)
    win32api.SetSystemTime(tm_year, tm_mon, tm_wday, tm_mday, tm_hour, tm_min, tm_sec, 0)
    # print(u'Set system time success.')


def get_old_time():
    with open('E:/vstsworkspace/projectXS/.git/hooks/temp_time.txt', 'r') as reader:
        temp_old_time = reader.readline()
    return float(temp_old_time)


if __name__ == '__main__':
    old_time = get_old_time()
    settime(old_time)
    sys.exit()
