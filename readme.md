# 使用步骤

- 使用FireFox浏览器驱动（可更改）

- 1.运行takeData.java 生成data.csv文件，文件生成路径可参考 takeData.java的第55行代码  （使用了Jsoup，运行时应该导入Jsoup依赖）
- 2.运行github_trending.py，在运行之前， 在代码第10行的路径应填写第一步的takeData.java生成的data.csv文件的路径地址

## 存在的问题

- 在运行takeData.java的时候，在网络不好的情况下，可能会抛出异常。

- 在运行github_trending.py浏览项目的时候，第二个项目仓库打开后停留的时间过长，大该在1分10秒左右，经过分析，发现很可能是第二个项目仓库的主页中，作者添加了一些动态图片资源，导致网页加载速度变慢导致的

