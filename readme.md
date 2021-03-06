# 设计说明 #
[![](https://img.shields.io/badge/JAVA-PASS-brightgreen.svg)]()
## 一、主要类及其含义
    
### 类名	含义
1. `Shopping`	模拟顾客购物，运行后进入`Market`  
1. `Market`	模拟商场  
1. `LogIO`	生成购物记录文件，传输数据  
1. `Casher`	模拟收银台  
1. `ShoppingCart`	模拟购物车

## 二、设计思路
![](https://github.com/AutuanLiu/Program/blob/master/设计思路.png)
## 三、个性化设置
- 主窗口为Market窗口，位于屏幕的左上角，Shoppingcart窗口为副窗口，则其位于主窗口的右侧，并与主窗口对齐，另一个副窗口为Casher窗口，其位于主窗口的下方，并与主窗口对齐；
- 对于可操作的按钮和标题进行了背景颜色的设置，使其更加醒目；
- 考虑了控件，文字及窗口的布局管理，使得整体看起来完整一体，避免了窗口重叠的现象；
- 在主窗口的中下方插入一个文本框，专门用来提示用户的操作结果，避免了用户在不知道结果的情况下拜拜等待的现象的发生；
- 利用线程的sleep（）方法，来模拟实际情况中的网络通信时间，
## 四、字体编码的处理
+ 为避免文件中的文字在写入读出或者从不同窗口写入读出时，发生乱码的现象，在处理时，将其编码方式设置为`gbk`，当然也可以采用`utf-8`等格式，另外，考虑到本地`windows`系统的默认编码格式为`gbk`，为了保持编码格式的一致性及编译时命令的简洁性，代码的编码格式也采用`gbk`编码。当然，若考虑到`java`的跨平台性，采用`utf-8`编码才更为合理，此程序主要考虑到中国用户的习惯，因此同意**采用`gbk`编码。**
## 五、消费记录的保存
+ 保存在当前目录下的record.txt文件中。
## 六、优缺点
### (1)优点
- 1.能够模拟出电子商务中的购物车，商店，收银台等模型及顾客购物的行为模型；
- 2.能够通过文本文档记录顾客的购物清单，有利于日后对用户购物清单的分析与计算，以期获得用户的购物习惯，也可以增加”推荐”等功能；
- 3.商店商品清单，购物清单等一目了然，操作按钮等进行了人性化设计，便于用户快速找到操作按钮。
- 4.能够考虑到数据的安全性，重复读，脏数据等情况，对可编辑区域适时地加锁与解锁。
### (2)缺点与改进方法
###### 本程序只考虑了单一线程即单一顾客的情况，事实上现实情况并非这样，因此，改进之处是:采用多线程处理，具体实现方法有:
 - （1）为每个顾客构造一个线程
 - （2）利用线程池等；
 + 1.本程序是在仓库容量无限大，即每种商品都不会缺货的情况下实现的，这也与实际情况不相符合，改进方法，引入商品存量这一属性，在处理数据时采用synchronize同步方法或对象；
 - 2.只考虑了客户端和服务端的部分情况，改进方法为设置普通用户和管理员，管理员可更改库存等属性。
 - 3.数据的传输应当采用Socket实现才比较合理。（鉴于只做本地化处理及我学艺不精，因此采用了本地文件进行数据的传输）。
## 七、附件说明
**附件主要包括**：
- 设计文档，一份；报名表，一份；
- `*.java`文件，5个（可以通过记事本，`gvim`，`notepad++`等查看源码）；
- `*.class`文件，15个；`*.jar`文件，一份。
## 八、开发环境及工具
- 基于`jdk8u66`，开发工具使用`eclipse`，并在其上编译通过并成功运行；
+ 同时，`dos`或`gvim`下使用命令进行测试，也已编译成功并运行。
## 九、参考文献
+ （1）《*java语言与面向对象程序设计*》，印晏，王行言，清华大学出版社
+ （2）《*java网络编程精解*》，孙卫琴，电子工业出版社
## 十、程序运行
+ 源码保存在解压后的Code文件夹内，可通过记事本查看。
#### 运行该程序主要有三种方式:
+ （1） :smile:
- 进入解压后的文件夹中的Shop子文件夹，双击`Shop.jar`， 即可正确运行，前提是你的电脑中有安装配置JDK。
- 首先，弹出主窗口，显示商店的商品信息

![](https://github.com/AutuanLiu/Program/blob/master/%E6%88%AA%E5%9B%BE/%E4%B8%BB%E7%AA%97%E5%8F%A3.PNG)

* 下方提示窗口显示欢迎信息。
向文本框中输入购买的数量，不购买则默认为0，不做修改，点击“加入购物车”按钮，即可将顾客的购买信息加入购物车，同时在当前目录下，生成  recoed.txt  文件，用于记录顾客的购买信息，在下方的提示窗口显示“加入购物车成功”，窗口的最下方中部标签处显示本次消费总额。 

![](https://github.com/AutuanLiu/Program/blob/master/%E6%88%AA%E5%9B%BE/%E7%A1%AE%E5%AE%9A.PNG)	

* 注意：购买数量栏不可为空，否则会提示“输入有误”*

![](https://github.com/AutuanLiu/Program/blob/master/%E6%88%AA%E5%9B%BE/%E9%94%99%E8%AF%AF1.PNG)

* 点击“查看购物车”按钮，即可弹出购物车，同时，购买数量处的文本框变为不可编辑状态，若点击“修改购物车”按钮，则各个文本框重新获得编辑权限。

![](https://github.com/AutuanLiu/Program/blob/master/%E6%88%AA%E5%9B%BE/%E8%B4%AD%E7%89%A9%E8%BD%A6.PNG)

* 窗口的左侧显示，顾客的购买时间，右侧显示顾客的购买物品名字、数量及消费总额。也可以通过查看当前目录下的的record.txt 文件查看购物记录。
* 点击购物车窗口右侧的“确定”按钮，文本域内显示提示文字。
* 若在主窗口点击“确认付款”按钮即可弹出 收银台 窗口，提示付款成功。

![](https://github.com/AutuanLiu/Program/blob/master/%E6%88%AA%E5%9B%BE/%E6%94%B6%E9%93%B6%E5%8F%B0.PNG)

1.关闭，两个副窗口不会关闭主窗口，但是，当关闭主窗口是，会结束程序的运行。
2.打开cmd，进入解压后的文件夹Class子文件夹，并输入 Java Shopping，即可运行程序（已经编译过，无需进行编译），运行过程同（1）。
3.使用IDE——eclipse，将Class下的源码复制到eclipse下的某一个project内，并执行，运行过程同（1）。
4.打开cmd，进入解压后的文件夹Shop子文件夹，并输入 java -jar Shop.jar，即可运行程序，运行过程同（1）。

**date**  
 **2015/11/25** 
