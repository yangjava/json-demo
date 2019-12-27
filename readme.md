目录 JSON 手册JSON简介JSON 实例JSON结构JSON形式：JSON对象objectJSON数组arrayJSON值valueJSON字符串stringJSON数值numberJSON 布尔值JSON nullJSON 文件

JSON 手册

JSON简介

JSON(JavaScript Object Notation)是一种轻量级的数据交换格式，它基于JavaScript的一个子集，易于人的编写和阅读，也易于机器解析。

JSON采用完全独立于语言的文本格式，但是也使用了类似于C语言家族的习惯（包括C, C++, C#, Java, JavaScript, Perl, Python等）。 这些特性使JSON成为理想的数据交换语言。

JSON 实例

    {
      "users": [
      { "name":"杨京京",age:18},
      { "name":"张三" , age:15},
      { "name":"李四" , age:16}
      ]
    }

这个 users对象是包含 3 个用户对象（对象）的数组。

JSON结构

JSON由两种结构组成：

1. 键值对的无序集合——对象(或者叫记录、结构、字典、哈希表、有键列表或关联数组等)
2. 值的有序列表——数组

这些都是常见的数据结构。事实上大部分现代计算机语言都以某种形式支持它们。这使得一种数据格式在同样基于这些结构的编程语言之间交换成为可能。

JSON形式：

JSON对象object

对象是一个无序键值对的集合，以"{"开始，同时以"}"结束，键值对之间以":"相隔，不同的键值对之间以","相隔。





举例

    {
        "name" : "杨京京",
        "age" : 18
    }

JSON数组array

数组是值（value）的有序集合。一个数组以“[”（左中括号）开始，“]”（右中括号）结束。值之间使用“,”（逗号）分隔。





举例

    [ "Google", "baidu", "Taobao" ]

或者

JSON对象中的数组

    {
    "name":"用户",
    "num":3,
    "sites":[ "杨京京", "张三", "李四" ]
    }

JSON值value

值（value）可以是双引号括起来的字符串（string）、数值(number)、true、false、 null、对象（object）或者数组（array）。这些结构可以嵌套。





JSON 值可以是：

- 字符串（在双引号中）
- 数字（整数或浮点数）
- 逻辑值（true 或 false）
- 数组（在中括号中）
- 对象（在大括号中）
- null

JSON字符串string

字符串（string）是由双引号包围的任意数量Unicode字符的集合，使用反斜线转义。一个字符（character）即一个单独的字符串（character string）。

字符串（string）与C或者Java的字符串非常相似。



举例

    {
        "name" : "杨京京"
    }



JSON数值number

数值（number）也与C或者Java的数值非常相似。除去未曾使用的八进制与十六进制格式。除去一些编码细节。



    {
        "age" : 18
    }

JSON 布尔值

JSON 布尔值可以是 true 或者 false：

举例

    {
         "flag":true
    }

JSON null

JSON 可以设置 null 值：

    { "name":null }

空白可以加入到任何符号之间。

JSON 文件

- JSON 文件的文件类型是 ".json"
- JSON 文本的 MIME 类型是 "application/json"




