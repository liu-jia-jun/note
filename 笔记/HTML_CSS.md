# HTML

> HTML 指的是一种超文本标记语言,用来描述网页的一种语言

## 基本标签

```html
标题标签：<h1>h1~h6，h1字体最大，h6字体最小</h1>
段落标签：<p>用于文本段落</p>
换行标签：<br>
加粗标签：<strong>用于加粗</strong>
删除线标签：<del>删除线标签</del>
下划线标签：<ins>下划线标签</ins>
```

## div与span

> + div 标签所代表的元素为块级元素，```<div>块级元素</div>```会独占一行显示
>
> + span标签所代表的元素为行内元素，```<span>行内元素</span>```每个span元素紧靠排列

## 图片标签

### img

```html
<img src="图片地址" alt="当图片不显示时出现的提示文本" title="当鼠标处于图片上时显示的文本" widht="npx" height="npx" />

```

### 地址

> + 相对路径：图片相对于html文件的位置
>
>   > **地址操作符**
>   >
>   > + ../ 回到上一级目录
>   > + ./ 或者 / 下一级
>
> + 绝对路径：图片相对于本机的位置
>
> + 相对路径  ——》 / 绝对路径 ——》 \

 

## 超链接

### a标签

```<a href="跳转目标" target="跳转方式">点击跳转</a>```

**跳转目标**

1. 外部链接：```<a href="http://www.baidu.com" target="跳转方式">点击跳转</a>```
2. 内部链接```<a href="test.html" target="跳转方式">点击跳转</a>```
3. 空链接```<a href="#" target="跳转方式">点击跳转</a>```
4. 锚点链接```<a href="#id" target="跳转方式">点击跳转</a>```

**跳转方式**

+    _self ：在本窗口打开页面
+ _blank：在新建窗口打开页面

**网页中的元素进行页面的跳转，元素可以是图片，文本等**

## 注释和特殊字符

> + 空格：&nbsp
> + 小于号：&lt
> + 大于号：&gt
> + 人名币：&yen
> + 注释：```<!-- 注释内容-->``` 网页中注释的部分是不会被浏览器解析的



## 表格

### table标签



```
   <!-- 
   table：表格区域，用于包含th，td，tr
   th；表头
   tr：表示一行，用于包含td
   td：表示一行中的一个单元格，单元格中包含元素
   -->
   <table>
        <th>
            表头
        </th>
        <tr>
              
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
    </table>
```

### 表格属性

> align :表格相对于周围元素的对齐方式
>
> > + left
> > + center
> > + right
>
> border:表格是否带有边框
>
> > 0 或者 1
>
> cellpadding：内容与单元格间的距离
>
> > npx
>
> cellspacing：单元格与单元格之间的距离
>
> > npx
>
> width：宽
>
> > npx
>
> height：高
>
> > npx

### 合并单元格

+ 跨行合并：rowspan = "合并单元格的个数"
+ 跨列合并：colspan ="合并单元格的个数"

**合并之后需要删掉多余的单元格**

## 列表

```
 <!-- 无序列表 -->
 <ul>
        <li></li>
        <li></li>
        <li></li>
    </ul>
     <!-- 有序列表 -->
    <ol>
        <li></li>
        <li></li>
        <li></li>
    </ol>
     <!-- 自定义列表 -->
    <dl>
        <dt></dt>
        <dd></dd>
        <dd></dd>
        <dd></dd>
    </dl>
```



## 表单

### 表单标签



```html
    <form action="提交地址" method="post">

        <input type="text" placeholder="请输入">
        <input type="password" placeholder="请输入">

        <input type="submit" value="提交">
        <input type="radio" name="" id="">
        <input type="checkbox">
        <input type="checkbox">
        <input type="checkbox" checked>
        <select name="" id="">
            <option value="1">1</option>
            <option value="2">3</option>
            <option value="3">a</option>
        </select>
        <textarea>
            文本域
        </textarea>
        <input type="submit" value="提交">
    </form>
```

### 表单属性

> action：用于指定接收并处理表单的服务器程序的url地址
>
> methon：表单提交方式
>
> name：名称
>
> id：id值
>
> type：输入框类型
>
> checked
>
> value
>
> placeholder：输入时的提示文本
>
> maxlength：输入字符串的最大长度



# CSS

## css样式写法

>+ ```
>  内嵌式
> ```
><div style="color:red; font-size:16px;"></div>
><div style="color:red; font-size:18px">内嵌式</div>
>
>
>````
>```
>内部样式
><style>
>.demo1 {
>	样式;
>}
>.demo2 {
>	样式;
>}
>
></style>
>````
>
>+ ```
><!-- 通过link标签将css文件引入到本页面中，那么该css文件中的样式可以被本页面使用 -->
> <link rel="stylesheet" href="style.css">
>
>```

## 选择器

> + 通配符选择器：给页面全部元素添加样式
>
>   ```html
>   *{
>   	样式;
>   }
>   ```
>
>   
>
> + 标签选择器：通过标签名进行选择，给选中的元素添加样式
>
>   ```html
>   标签名 {
>   	样式;
>   }
>   eg:
>   div{
>   	样式;
>   }
>   ```
>
>   
>
> + 类选择器：类名取名可以重复，相同类名的元素为一组，不能以标签名作为类名，一个元素可以有多个类名
>
>   ```
>   .类名 {
>   	样式;
>   }
>                                       
>   eg:
>   .demo1 {
>   	样式;
>   }
>   .demo2 {
>   	样式;
>   }
>                                       
>   <div class="demo1 demo2" >类选择器通过类名选择元素</div>
>   ```
>
>   
>
> + id选择器
>
>   ```
>   #id名 {
>   	样式;
>   }
>                                       
>   eg:
>   #demo {
>   	样式;
>   }
>                                       
>   <div id="demo" >id选择器通过id名选择元素</div>
>   ```
>
>   

## 字体样式

+ font-family："字体";	设置字体样式
+ font-size：npx    ;        设置字体大小
+ font-weight：700;（加粗）400（正常）设置字体的粗细
+ font-style：normal（正常） | italic(倾斜);     设置字体样式，正常或倾斜

**font：font-style  font-weight  font-size  font-family**

## 文本样式

| color           | red                                  | 设置文本颜色                         |
| --------------- | ------------------------------------ | ------------------------------------ |
| text-align      | left，center，right                  | 设置盒子内文本的水平方向上的对齐方式 |
| text-decoration | none,underline,overline,line-thorugh | 给文本添加下划线，上划线，删除线     |
| text-indent     | n em（em相当于一个字的大小）         | 设置文本的第一行缩进，               |
| line-height     | npx                                  | 行间距，文字与行间的距离             |

**设置行间距为盒子高度，可以让文字垂直居中**

## 复合选择器

+ 后代选择器：也称为包含选择器，选择到子类或者包含在元素1中的所有的元素2

  ```
  元素1(父元素) 元素2 {
  	样式代码;
  }
  
  div span{
  	样式代码;
  }
  
  ```

+ 子元素选择器：选择父元素的最近的子元素

  ```html
  父类元素 > 子类元素 {
  	样式代码;
  }
  
  #a > #b{
  	样式代码;
  }
  ```

+ 并集选择器：用于选择多个元素，可以将任何形式的选择器作为并集的一部分

  ```
  元素1,元素2,元素3{
  	样式代码;
  }
  
  ```

## 链接伪类选择器

+ a:link	选择未被访问的链接
+ a:visited  选择已被访问的链接
+ a:hover   选择鼠标指针位于其上的链接
+ a:active    选择鼠标按下未弹起的链接

```
需要按照一定的顺序来写——>  LVHA

语法：
	a:hover{
		样式代码;
	}
```



## 元素的显示模式

### 块级元素

> h1~h6 , div , ul , ol , li , p

**特点**

1. 具有宽和高的属性
2. 块级元素会独占一行
3. 内外边距都可以控制
4. 宽度默认是父级盒子的宽度
5. 是一个盒子或者容器，其中可以放块级元素也可以放行内元素

**注意：文本类元素内不能使用块级元素**

### 行内元素

> span , a 

**特点**

1. 一行紧靠排列
2. 没有宽和高的概念，宽和高就是根据内容本身的宽和高
3. 行内元素只能容纳文本或者其他行内元素

**注意**

1. 链接中不能再链接 
2. a标签中可以含有块级元素

### 行内块元素

> img, input, td

**特点**

1. 一行显示	行内元素的特点
2. 可以设置宽和高   块级元素的特点

### 元素显示转换

**display**

1. 将行内元素转换为块级元素	display:block;
2. 将块级元素转换为行内元素	display:inline;
3. 将元素转换为行内块元素	display:inline-block;
4. 控制元素不显示                    display：none  

## 背景

### 背景颜色

| background-color      | red,rgb,rgba,十六进制                       | 设置背景颜色                       |
| --------------------- | ------------------------------------------- | ---------------------------------- |
| background-image      | url(背景图片的地址)                         | 设置背景图片                       |
| background-repeat     | repeat，no-repeat , repeat-x , repeat-y     | 设置背景图片是否平铺               |
| background-position   | npx,npx; center,top,right,left              | 设置背景图片的位置                 |
| background-attachment | scroll（随其他内容滚动） 或者 fixed（固定） | 设置背景图片是否固定或者随页面滚动 |

## CSS特性

1. 层叠性：若存在样式冲突，则为就近原则
2. 继承性：子标签可以继承父标签一些属性
   1. text-
   2. font-
   3. line-
   4. color
3. 优先级：id>class>div>*
4. 复合选择器会存在权重的叠加，相同层次才会出现叠加，**权重只会叠加不会进位**

## 盒子模型

### 边框

| border-width | npx                                       | 设置边框的大小     |
| ------------ | ----------------------------------------- | ------------------ |
| border-style | solid（实线）dashed（虚线）dotted（点线） | 设置边框的样式     |
| border-color | red                                       | 设置边框的颜色     |
| border       | width style color                         | 边框设置的复写方式 |

### 内边距：padding

```
padding:  上左下右		npx;
		  上下  左右	npx npx;
		  上  左右  下	npx npx npx;
		  上 右 下 左   npx npx npx npx;
```

> 注意边框会影响盒子的实际大小

| padding-top    | 上内边距 |
| -------------- | -------- |
| padding-bottom | 下内边距 |
| padding-left   | 左内边距 |
| padding-right  | 右内边距 |

#### 关于padding的应用

1. 导航栏中的元素设置相同的padding，不需要设置宽度
2. 对于有宽和高的盒子padding和border会撑大盒子
3. 对于没有宽和高的盒子padding和border不会撑大盒子

**盒子的实际大小**

border，padding，width都会影响盒子的实际大小

**size = width + border + padding	宽度**

**size = height + border + padding	高度**



###  外边距：margin

```html
margin:   上左下右		npx;
		  上下  左右	npx npx;
		  上  左右  下	npx npx npx;
		  上 右 下 左   npx npx npx npx;
```

| margin-top    | 上外边距 |
| ------------- | -------- |
| margin-bottom | 下外边距 |
| margin-left   | 左外边距 |
| margin-right  | 右外边距 |

#### margin的应用

1. margin：npx auto; 使得块级元素水平居中
   1. 该块级元素需要有宽度
   2. 将左外边距和右外边距设置成auto
2. 父元素中添``` text-align:center;``` 设置行内元素和行内块元素水平居中显示

### 外边距合并问题

1. 外边距塌陷

> 当上下相邻的两个块级元素相遇的时候，上面的元素设置了下外边距，下面的元素设置了上外边距，此时两个块级元素上下之间的距离为其中一个元素的外边距值较大的哪一个，而非两个外边距之和，这个称为外边距的合并或者外边距塌陷

2. 嵌套块级元素垂直外边距的合并

   >对于两个嵌套的块级元素，如果父级没有上外边距，或者边框的时候，而子元素设置了上外边距时，会发生合并，即较大的外边距值应用到父元素的外边距上（垂直方向上才会出现合并现象）
   >
   >

### 清除内外边距

```html
*{
	padding:0px;
	margin:0px;                                                                   
}
```



## 圆角边框

```html
border-radius:npx;
npx,值越大，圆角越圆
原理为圆与边框的交集形成的圆角效果


将一个盒子设置成圆角矩形
border-radius:50%;


设置不同的圆角
border-top-right-raidus:npx
border-top-left-raidus:npx
border-buttom-right-raidus:npx
border-buttom-left-raidus:npx
```

### 阴影

#### 盒子阴影

**box-shoadow**

```html
box-shadow:h-shadow v-shadow blur spread color insert;

eg: box-shadow: 2px 2px 2px 2px black inset;

h-shadow:npx;	设置水平方向上的阴影位置  必须设置
v-shadow:npx;	设置垂直方向上的阴影	必须设置
blur:npx;		设置模糊距离	可选
spread:npx;		设置阴影尺寸	可选
color:red;		设置阴影颜色	可选
inset:inset;	将外部阴影设置为内部阴影
```

#### 文字阴影

```html
text-shadow:h-shadow v-shadow blur spread color insert;

eg: text-shadow: 2px 2px 2px 2px black inset;

h-shadow:npx;	设置水平方向上的阴影位置  必须设置
v-shadow:npx;	设置垂直方向上的阴影	必须设置
blur:npx;		设置模糊距离	可选
spread:npx;		设置阴影尺寸	可选
color:red;		设置阴影颜色	可选
inset:inset;	将外部阴影设置为内部阴影
```

## 浮动

> 传统网页布局的三种方式
>
> + 标准流（文档流）
> + 浮动
> + 定位
>
> 网页布局的原则：多个块级元素纵向排列使用标准流
>
> ​								多个块级元素横向排列使用浮动



### float

> 用于创建浮动框，将其移动直到触及父盒子的边框或者另一个浮动框的边框

```html
float:left; 向左浮动
float:right;向右浮动
```

**特点**

1. 脱离标准流浮动（脱标）
2. 如果多个盒子都设置了浮动则它们会按照属性值（float：left | right）一行显示并顶端对齐排列
3. 任何元素都可以添加浮动，浮动之后的元素有行内块元素的特性



**网页布局准则：先设置盒子的大小后设置盒子的位置**

### 清除浮动

> 为什么需要清除浮动
>
> ​	由于父盒子很多情况下不方便设置准确的高度，但是子盒子浮动不占位置，导致父级盒子高度为0，会影响其他标准流元素
>
> 清除浮动的本质
>
> ​	清除浮动元素所带来的影响

1. 额外标签法

   + ```clear：left | right | both; 分别是清除左侧浮动的影响，清除右侧浮动的影响，清除两侧浮动的影响```

2. 给父级元素添加overflow属性

   + ```html
     父级元素 {
     	overflow:hidden;
     }
     ```

     

> 注意：浮动的盒子只会影响浮动盒子后面的标准流，不会影响前面的标准流

## 定位：position

> 定位：将一个盒子定在某一个位置，所以定位也是摆放盒子，按照定位的方式移动盒子

**定位 = 定位模式 + 偏移量**

### 定位模式

+ static		静态定位	默认方式
+ relative    相对定位    相对于元素原来的位置进行移动，不会脱标，会占有原来的位置
+ absolute  绝对定位  
  +   相对于祖先元素进行移动
  + 如果祖先元素有定位，则以最近一级的有定位的祖先元素为参考进行移动
  + absolute 定位是不占有原来的位置的（脱标）
+ fixed         固定定位
  + 以浏览器可视窗口为参照进行位移，于父级元素无关
  + 不随滚动条滚动
  + 不占有原来的位置（脱标）
+ sticky        粘性定位    最少定位一个偏移量

### 偏移量

> top（相对于bottom优先显示）	bottom	left（相对于right优先显示）	right
>
> 通过设置top等属性来设置偏移量
>
> ```html
> 元素 {
> 	top:npx;
> 	bottom:npx;
> 	left:npx;
> 	right:npx;
> }
> ```

### 子绝父相

> 子元素使用了绝对定位时，需要给父级元素使用相对定位
>
> 总结：因为父元素需要占有位置，因此为相对定位
>
> ​			为了限制子元素能在父级盒子中内显示，也是为了不影响其他的兄弟盒子，所以为绝对定位

### 定位叠放次序

> 在定位布局时可能会出现盒子重叠的情况，此时可以使用```z-index:n;```来控制盒子的前后次序，这里的前后是z轴上的显示效果

```html
定位元素 {
	z-index:n;
}
这里的n可以为正整数，负整数或者0，默认为auto，数值越大盒子越靠上
```

**注意**

1. 如果z-index的属性值相同则通过书写顺序控制，后来者居上
2. 这里的n没有单位，且只有定位的盒子才有z-index属性

### 定位拓展

**绝对定位的盒子居中**

> 因为加了绝对定位的盒子不能通过```margin:auto;```来实现水平居中，但是可以通过left和top来实现居中
>
> ```html
> 定位元素 {
> 	top:50%;
> 	left:50%;
> 	margin-left:-1/2*width;
> 	margin-top:-1/2*height  ;
> }
> top:50%;这样设置可以让绝对定位的盒子的左侧移动到相对于父元素的水平方向上的中心位置
> left:50%;这样设置可以让绝对定位的盒子的上侧移动到相对于父元素的垂直方向上的中心位置
> ```



### 定位特点

1. 行内元素添加绝对定位或者固定定位，可以直接设置宽和高
2. 块级元素添加绝对或固定定位，如果不设置宽和高则默认大小为内容大小
3. 浮动元素，绝对定位元素，固定定位元素了，不会触发外边距合并问题（即元素脱标之后都不会触发外边距合并问题）

**注意**

>绝对定位和固定定位会完全压住盒子，压住标准流盒子中的所有内容
>
>浮动元素，只会压住它下面的标注流的盒子，但是浮动元素不会压住文字和图片
>
>因为：浮动最初就是用来实现文字环绕效果的，文字或者图片会围绕浮动元素

## 元素的显示与隐藏

### display

+ display：none；隐藏元素
+ display：block；显示元素，并转为块级元素

> 注意：display：隐藏元素之后，不占有原来的位置

### visibility

+ visibility：visible；元素可见
+ visibility：hidden；元素隐藏

> 注意：visibility 隐藏元素之后，会继续占有原来的位置

### overflow

> overflow 对盒子中内容溢出的部分进行显示隐藏

+ overflow：visible	默认
+ overflow：hidden   隐藏超出盒子尺寸的内容
+ overflow：scroll      显示滚动条
+ overflow：auto        自适应，内容超出则显示滚动条，不超出不显示	

http://www.baidu.com

## CSS用户界面样式

### 鼠标样式：cursor

```
cursor:default;	默认白色箭头
	   pointer;	小手
	   move;	移动
	   text;	文本
	   not-allowed;禁止  
```



### 轮廓线：outline

> 用于去掉表单上的轮廓线	outline：none
>
>  
>
> tips：防止文本域被拖拽 resize：none;



## vertical-align

> 用于设置图片表单与文字的垂直对齐
>
> 用于设置一个元素的垂直对齐方式，但是它针对行内元素或者行内块元素

```html
vertical-align:baseline;	基线对齐 默认，将元素放置在父元素的基线上
			   top;			顶部对齐 把元素的顶端与行内最高元素的顶端对齐
			   middle;		中部对齐 把此元素放到父元素的中部
			   bottom;		底部对齐 把元素的顶部与行内最低元素的顶部对齐
			   
```



## HTML5

语义化标签

```html
<header>头部标签</header>
<nav>导航栏标签</nav>
<article>内容标签</article>
<section>定义文档的某个区域</section>
<aside>侧边栏标签</aside>
<footer>尾部标签</footer>
```

**这些标签表示的都是类似于div的盒子，只是通过不同单词表现出来，实现语义化**

 

