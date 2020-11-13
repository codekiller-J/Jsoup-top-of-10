import csv
import time
import unittest

from ddt import ddt,data,unpack
from selenium import webdriver



def getCsv():
    rows = []

    csv_file = open('E:\Jsoup\data.csv')           # 填入路径为 java的Jsoup生成的文件路径地址
    readers=csv.reader(csv_file)
    for i in readers:
        rows.append(i)
    return rows


@ddt
class github(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()

        self.base_url = "https://github.com/login"



    def tearDown(self):
         self.driver.quit()



    @unpack
    @data(*getCsv())
    def test_github10(self, p_name, p_star, p_branch, main_contributors_first, main_contributors_second,
                      main_contributors_thrid, main_contributors_fourth, main_contributors_fifth,nu_ll):

        driver = self.driver
        driver.get(self.base_url)
        driver.implicitly_wait("5")
        driver.maximize_window()
        driver.implicitly_wait("5")
        driver.find_element_by_id("login_field").send_keys("wow1042631271@163.com")
        driver.find_element_by_id("password").send_keys("Qq1042631271")
        driver.implicitly_wait("5")
        driver.find_element_by_name("commit").click()
        driver.implicitly_wait("5")
        driver.get("https://github.com/" + p_name)
        time.sleep(5)
        


if __name__ == "main":
    unittest.main()