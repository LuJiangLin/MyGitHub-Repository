1.第一步:整合olala-shop里面的三种支付
   支付宝支付
   微信支付
   银联支付





2.第二步:整合IJPay项目中的支付



【项目问题】:
1.微信解析xml和maven中jar关于Node.getTextContent()冲突,文件是XmlHelper.java
解决办法:
Node.getTextContent()是org.w3c.dom.Node下面的方法，这个包是JDK自带的，这所以会出现getTextContent找不到是因为jar包的冲突，
由于加载顺序先后问题导致冲突，可以在build path里面修改加载顺序，可解决本地jar冲突问题，但不是根本上解决，如图：
项目右键单击→Build Path→Configure→Order and Export然后选择Maven或者JRE，进行Down或者Up，把JRE放到Maven之前就可以解决冲突。
但不是根本上解决。
博客:https://blog.csdn.net/heboy19/article/details/49151195

2.