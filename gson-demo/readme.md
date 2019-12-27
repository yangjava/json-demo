Gson手册

简介

Google Gson是一个简单的基于Java的库，用于将Java对象序列化为JSON，反之亦然。 它是由Google开发的一个开源库。

特点

- 易于使用 -Gson API提供了一个高级外观来简化常用的用例。
- 无需创建映射 - Gson API为大部分要序列化的对象提供了默认映射。
- 性能优 - Gson速度相当快，内存占用量低。 它适用于大型对象图或系统。
- 干净JSON - Gson创建一个干净而紧凑的JSON结果，它易于阅读。
- 无依赖性—Gson库不需要JDK以外的任何其他库。
- 开源 - Gson库是开源的; 它是免费提供的。

优点

标准化 - Gson是一个由Google管理的标准化库。

高效 - 这是对Java标准库的可靠，快速和高效的扩展。

优化 - Gson库经过高度优化。

支持泛型 - 它为泛型提供了广泛的支持。

支持复杂的内部类 - 它支持具有深度继承层次结构的复杂对象。

入门

Maven

    <!--http://www.mvnrepository.com/artifact/com.google.code.gson/gson-->
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.8.2</version>
    </dependency>

示例代码

登录用户模型

    package com.demo.gson;

    import lombok.Data;

    import java.io.Serializable;
    import java.util.Date;

    @Data
    public class LoginAccount implements Serializable {

        private Long id;

        private String loginName;

        private String type;

        private Date LoginTime;
    }


用户模型

    package com.demo.gson;

    import lombok.Data;
    import lombok.ToString;

    import java.io.Serializable;
    import java.util.Date;
    import java.util.List;

    @Data
    @ToString
    public class User implements Serializable {

        private Long id;

        private String name;

        private Integer age;

        private Date birthDay;

        private Boolean isMale;

        private Double balance;

        private List<LoginAccount> loginAccountList;
    }


Gson代码

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class HelloWorld {

        public static void main(String[] args) {
            //创建一个Gson对象
            GsonBuilder builder = new GsonBuilder();
    //        builder.setPrettyPrinting();
            Gson gson = builder.create();

            //将对象序列化为JSON
            User user = new User();
            user.setId(1L);
            user.setName("杨京京");
            user.setAge(18);
            user.setIsMale(true);
            user.setBirthDay(new Date());
            user.setBalance(100000.00);
            String jsonString = gson.toJson(user);

            System.out.println("========");
            System.out.println(jsonString);
            System.out.println("========");
            //将JSON反序列化为对象
            String s = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0}";
            User userInfo = gson.fromJson(jsonString, User.class);
            System.out.println(userInfo.toString());
        }
    }


业务说明

- 使用GsonBuilder创建Gson对象
创建一个Gson对象。 它是一个可重用的对象。
              GsonBuilder builder = new GsonBuilder();
              builder.setPrettyPrinting();
              Gson gson = builder.create();
- 将对象序列化为JSON
      String jsonString = gson.toJson(user);
- 将JSON反序列化为对象
      User userInfo = gson.fromJson(jsonString, User.class);

核心

Gson

Gson是Google Gson库的主要操作类。 它提供了将对象序列化为JSON和将JSON反序列化为对象。 Gson首先使用GsonBuilder构建，然后使用toJson(Object)或fromJson(String，Class)方法读取/写入JSON构造。

类方法

  编号  	方法                                      	描述
  1   	T fromJson(JsonElement json, Class classOfT)	此方法将从指定分析树读取的Json反序列化为指定类型的对象。
  2   	T fromJson(JsonElement json, Type typeOfT)	此方法将从指定分析树读取的Json反序列化为指定类型的对象。
  3   	T fromJson(JsonReader reader, Type typeOfT)	从reader中读取下一个JSON值并将其转换为typeOfT类型的对象。
  4   	T fromJson(Reader json, Class classOfT) 	此方法将从指定Reader读取的Json反序列化为指定类的对象。
  5   	T fromJson(Reader json, Type typeOfT)   	此方法将从指定reader读取的Json反序列化为指定类型的对象。
  6   	T fromJson(String json, Class classOfT) 	此方法将指定的Json反序列化为指定类的对象。
  7   	T fromJson(String json, Type typeOfT)   	此方法将指定的Json反序列化为指定类型的对象。
  8   	TypeAdapter getAdapter(Class type)      	返回type的类型适配器。
  9   	TypeAdapter getAdapter(TypeToken type)  	返回type的类型适配器。
  10  	TypeAdapter getDelegateAdapter(TypeAdapterFactory skipPast, TypeToken type)	此方法用于获取指定类型的备用类型适配器。
  11  	String toJson(JsonElement jsonElement)  	将JsonElements树转换为其等效的JSON表示形式。
  12  	void toJson(JsonElement jsonElement, Appendable writer)	为JsonElements树写出等价的JSON。
  13  	void toJson(JsonElement jsonElement, JsonWriter writer)	将jsonElement的JSON写入writer。
  14  	String toJson(Object src)               	此方法将指定的对象序列化为其等效的Json表示形式。
  15  	void toJson(Object src, Appendable writer)	此方法将指定的对象序列化为其等效的Json表示形式。
  16  	String toJson(Object src, Type typeOfSrc)	此方法将指定对象(包括泛型类型的对象)序列化为其等效的Json表示形式。
  17  	void toJson(Object src, Type typeOfSrc, Appendable writer)	此方法将指定对象(包括泛型类型的对象)序列化为其等效的Json表示形式。
  18  	void toJson(Object src, Type typeOfSrc, JsonWriter writer)	将typeOfSrc类型的src的JSON表示写入writer。
  19  	JsonElement toJsonTree(Object src)      	此方法将指定对象序列化为与JsonElements树相同的表示形式。
  20  	JsonElement toJsonTree(Object src, Type typeOfSrc)	此方法将指定对象(包括泛型类型的对象)序列化为与JsonElements树相同的表示形式。
  21  	String toString()                       	转化为字符串的形式。

高级

Gson提供了三种处理JSON的替代方法 -

1. 数据流

它读取和写入JSON内容作为离散事件。 JsonReader和JsonWriter将数据读取/写入令牌，称为JsonToken。

这是处理JSON的三种方法中最强大的方法。 它具有最低的开销，并且在读/写操作中速度非常快。 它类似于用于XML的Stax解析器。

2. 树模型
它准备JSON文档的内存树表示。 它构建了一个JsonObject节点树。 这是一种灵活的方法，类似于XML的DOM解析器。

3. 数据绑定
它使用属性访问器将JSON转换为POJO(普通旧Java对象)并从中转换。 Gson使用数据类型适配器读取/写入JSON。 它类似于XML的JAXB解析器。

数据流

Streaming API用于通过令牌读取JSON令牌。 它读取和写入JSON内容作为离散事件。 JsonReader和JsonWriter将数据读取/写入令牌，称为JsonToken。

这是处理JSON的三种方法中最强大的方法。 它具有最低的开销，并且在读/写操作中速度非常快。 它类似于用于XML的Stax解析器。

示例代码

    package com.demo.gson;

    import com.google.gson.stream.JsonReader;
    import com.google.gson.stream.JsonToken;

    import java.io.IOException;
    import java.io.StringReader;

    public class JsonReaderDemo {

        public static void main(String[] args) {

            String jsonString = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0}";
            JsonReader reader = new JsonReader(new StringReader(jsonString));
            try {
                readJsonObject(reader);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void readJsonObject(JsonReader reader) throws IOException {
            reader.beginObject();
            while (reader.hasNext()){
                JsonToken token = reader.peek();
                if(JsonToken.BEGIN_ARRAY.equals(token)){
                    readJsonArray(reader);
                }
                if(JsonToken.END_OBJECT.equals(token)){
                    reader.endObject();
                    return;
                }else{
                    readJsonToken(token,reader);
                }
            }

        }


        private  static void readJsonToken(JsonToken token,JsonReader reader)throws IOException{
            String fieldname = null;
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
            }
            if ("id".equals(fieldname)) {
                token = reader.peek();
                System.out.println("id: "+reader.nextLong());
            }
            if ("name".equals(fieldname)) {
                token = reader.peek();
                System.out.println("name: "+reader.nextString());
            }
            if("age".equals(fieldname)) {
                token = reader.peek();
                System.out.println("age: "+reader.nextInt());
            }
            if("birthDay".equals(fieldname)) {
                token = reader.peek();
                System.out.println("birthDay: "+reader.nextString());
            }
            if("isMale".equals(fieldname)) {
                token = reader.peek();
                System.out.println("isMale: "+reader.nextBoolean());
            }
            if("balance".equals(fieldname)) {
                token = reader.peek();
                System.out.println("balance: "+reader.nextDouble());
            }
        }

        private  static void readJsonArray(JsonReader reader) throws IOException {
            reader.beginArray();
            while (true) {
                JsonToken token = reader.peek();
                if (token.equals(JsonToken.END_ARRAY)) {
                    reader.endArray();
                    break;
                } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                    readJsonObject(reader);
                } else if (token.equals(JsonToken.END_OBJECT)) {
                    reader.endObject();
                } else {
                    System.out.print(reader.nextInt() + " ");
                }
            }
        }


    }

树模型

树模型准备JSON文档的内存树表示。 它构建了一个JsonObject节点树。 这是一种灵活的方法，类似于XML的DOM解析器。

示例代码

    package com.demo.gson;

    import com.google.gson.*;

    public class JsonParserDemo {

        public static void main(String[] args) {
            String jsonString = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0,\"marks\": [100,90,85]}";
            JsonParser parser = new JsonParser();
            JsonElement rootNode = parser.parse(jsonString);

            if (rootNode.isJsonObject()) {
                JsonObject details = rootNode.getAsJsonObject();

                JsonElement idNode = details.get("id");
                System.out.println("id: " + idNode.getAsLong());

                JsonElement nameNode = details.get("name");
                System.out.println("name: " + nameNode.getAsString());

                JsonElement ageNode = details.get("age");
                System.out.println("age: " + ageNode.getAsInt());

                JsonElement birthDayNode = details.get("birthDay");
                System.out.println("birthDay: " + birthDayNode.getAsString());

                JsonElement isMaleNode = details.get("isMale");
                System.out.println("isMale: " + isMaleNode.getAsBoolean());

                JsonElement balanceNode = details.get("balance");
                System.out.println("balance: " +balanceNode.getAsDouble());

                JsonArray marks = details.getAsJsonArray("marks");

                for (int i = 0; i < marks.size(); i++) {
                    JsonPrimitive value = marks.get(i).getAsJsonPrimitive();
                    System.out.print(value.getAsInt() + " ");
                }
            }

        }
    }


数据绑定

数据绑定API用于使用属性访问器或使用注释将JSON转换为POJO(普通旧Java对象)以及从POJO(普通旧Java对象)转换。 它有两种类型，分别如下所示 -

- 原始数据绑定 - 将JSON转换为Java地图，列表，字符串，数字，布尔值和NULL对象。
- 对象数据绑定 - 从任何JAVA类型转换JSON。

Gson为这两种类型的数据绑定读/写JSON。 数据绑定类似于XML的JAXB解析器。

原始数据绑定

基元数据绑定是指将JSON映射到JAVA核心数据类型和内置集合。 Gson提供了各种内置适配器，可用于序列化/反序列化原始数据类型。

    package com.demo.gson;

    import com.google.gson.Gson;

    import java.util.Arrays;

    public class GsonFieldDemo {

        public static void main(String args[]) {
            Gson gson = new Gson();
            Long id=1L;
            String name = "杨京京";
            Integer age =18;
            Boolean isMale=true;
            Double balance=100000.0;
            int[] marks = {100,90,85};

            //序列化成JSON
            System.out.println("{");
            System.out.println("id: " + gson.toJson(id) +",");
            System.out.println("name: " + gson.toJson(name) +",");
            System.out.println("age: " + gson.toJson(age) +",");
            System.out.println("isMale: " + gson.toJson(isMale) +",");
            System.out.println("balance: " + gson.toJson(balance) +",");
            System.out.println("marks:" + gson.toJson(marks));
            System.out.println("}");

            //反序列化成对象
            name = gson.fromJson("\"村长\"", String.class);
            age = gson.fromJson("15", Integer.class);
            isMale = gson.fromJson("false", Boolean.class);
            balance=gson.fromJson("200000.0", Double.class);
            marks = gson.fromJson("[100,90,85]", int[].class);

            System.out.println("name: " + name);
            System.out.println("age: " + age);
            System.out.println("isMale: " +isMale);
            System.out.println("balance: " +balance);
            System.out.println("marks:" + Arrays.toString(marks));
        }
    }


对象数据绑定

对象数据绑定是指将JSON映射到任何JAVA对象。

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.util.Date;

    public class GsonObjectDemo {

        public static void main(String[] args) {
            //创建一个Gson对象
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();

            //将对象序列化为JSON
            User user = new User();
            user.setId(1L);
            user.setName("杨京京");
            user.setAge(18);
            user.setIsMale(true);
            user.setBirthDay(new Date());
            user.setBalance(100000.00);
            String jsonString = gson.toJson(user);

            System.out.println("========");
            System.out.println(jsonString);
            System.out.println("========");
            //将JSON反序列化为对象
            String s = "{\"id\":1,\"name\":\"杨京京\",\"age\":18,\"birthDay\":\"Dec 26, 2019 1:39:20 PM\",\"isMale\":true,\"balance\":100000.0}";
            User userInfo = gson.fromJson(jsonString, User.class);
            System.out.println(userInfo.toString());
        }
    }


进阶

数组

    package com.demo.gson;

    import com.google.gson.Gson;

    import java.util.Arrays;

    public class GsonArrayDemo {

        public static void main(String args[]) {
            Gson gson = new Gson();
            int[] ages = {13,14,15};
            String[] names = {"张三","李四","王五"};

            //序列化
            System.out.print("{");
            System.out.print("ages:" + gson.toJson(ages) + ",");
            System.out.print("names:" + gson.toJson(names));
            System.out.println("}");

            //反序列化
            ages = gson.fromJson("[18,19,20]", int[].class);
            names = gson.fromJson("[\"侯六\",\"杨七\",\"冯八\"]", String[].class);
            System.out.println("ages:" + Arrays.toString(ages));
            System.out.println("names:" + Arrays.toString(names));
        }


    }


集合

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.reflect.TypeToken;

    import java.lang.reflect.Type;
    import java.util.ArrayList;
    import java.util.Collection;

    public class GsonCollection {

        public static void main(String args[]) {
            Gson gson = new Gson();
            Collection<Integer> ages = new ArrayList<Integer>();
            ages.add(13);
            ages.add(14);
            ages.add(15);

            //序列化
            System.out.print("{");
            System.out.print("ages:" + gson.toJson(ages));
            System.out.println("}");

            //反序列化
            Type listType = new TypeToken<Collection<Integer>>() {
            }.getType();
            ages = gson.fromJson("[17,18,19]", listType);
            System.out.println("ages:" + ages);
        }

    }


泛型

Gson使用Java反射API来获取要将Json文本映射到的对象的类型。 但是在泛型中，这些信息在序列化过程中丢失了。 为了解决这个问题，Gson提供了一个com.google.gson.reflect.TypeToken类来存储通用对象的类型。

形状模型

    package com.demo.gson;

    class Shape <T> {
        public T shape;

        public void setShape(T shape) {
            this.shape = shape;
        }
        public T get() {
            return shape;
        }
        public double getArea() {
            if(shape instanceof Circle) {
                return ((Circle)shape).getArea();
            } else {
                return 0.0;
            }
        }
    }

圆

    package com.demo.gson;

    import lombok.Data;
    import lombok.ToString;

    @ToString
    @Data
    public class Circle {

        private double radius;

        public Circle(double radius){
            this.radius = radius;
        }

        public double getArea() {
            return (radius*radius*3.14);
        }
    }

测试类

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.reflect.TypeToken;


    import java.lang.reflect.Type;

    public class TypeTokenDemo {

        public static void main(String args[]) {
            //创建Gson对象
            Gson gson = new Gson();

            Shape<Circle> shape = new Shape<Circle>();
            Circle circle = new Circle(5.0);
            shape.setShape(circle);

            Type shapeType = new TypeToken<Shape<Circle>>() {}.getType();

            //序列化
            String jsonString = gson.toJson(shape, shapeType);
            System.out.println(jsonString);

            //反序列化
            Shape shape1 = gson.fromJson(jsonString, Shape.class);
            System.out.println(shape1.get().getClass());
            System.out.println(shape1.get().toString());
            System.out.println(shape1.getArea());
            Shape shape2 = gson.fromJson(jsonString, shapeType);
            System.out.println(shape2.get().getClass());
            System.out.println(shape2.get().toString());
            System.out.println(shape2.getArea());
        }


    }


自定义类型适配器

Gson使用其内置适配器执行对象的序列化/反序列化。 它也支持自定义适配器。 让我们来讨论如何创建一个自定义适配器以及如何使用它。

通过扩展TypeAdapter类并传递目标类型的对象来创建自定义适配器。 重写读写方法分别执行自定义的反序列化和序列化。

示例代码

注册类型适配器：

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.sql.Timestamp;

    public class TimestampDemo {
        public static void main(String[] args) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Timestamp.class, new TimestampAdapter())
                    .create();
        }
    }

自己写的一个 Timestamp 类型适配器

    package com.demo.gson;

    import com.google.gson.*;

    import java.lang.reflect.Type;
    import java.sql.Timestamp;

    public class TimestampAdapter implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp> {

        @Override
        public Timestamp deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
            if (json == null) {
                return null;
            } else {
                try {
                    return new Timestamp(json.getAsLong());
                } catch (Exception e) {
                    return null;
                }
            }
        }

        @Override
        public JsonElement serialize(Timestamp src, Type typeOfSrc,
                                     JsonSerializationContext context) {
            String value = "";
            if (src != null) {
                value = String.valueOf(src.getTime());
            }
            return new JsonPrimitive(value);
        }

    }


空对象支持

Gson默认生成优化的Json内容，忽略NULL值。

但是GsonBuilder提供的标志使用GsonBuilder.serializeNulls()方法在Json输出中显示NULL值。

用法

    GsonBuilder builder = new GsonBuilder();
    builder.serializeNulls();
    Gson gson = builder.create();

代码示例

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.util.Date;

    public class SerializeNullsDemo {
        public static void main(String[] args) {

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            builder.serializeNulls();
            Gson gson = builder.create();
            User user = new User();
            user.setId(1L);
            user.setName("杨京京");
            user.setAge(18);
            user.setIsMale(true);
            user.setBirthDay(new Date());
            String jsonString = gson.toJson(user);
            System.out.println(jsonString);
        }
    }


结果如下

    {
      "id": 1,
      "name": "杨京京",
      "age": 18,
      "birthDay": "Dec 26, 2019 5:00:54 PM",
      "isMale": true,
      "balance": null,
      "loginAccountList": null
    }

版本支持

Gson提供了@Since注解来控制基于其各种版本的类的Json序列化/反序列化。

GsonBuilder提供了setVersion()方法来序列化这样的版本化类。

    GsonBuilder builder = new GsonBuilder();
    builder.setVersion(1.0);
    Gson gson = builder.create();

示例代码

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.util.Date;

    public class GsonVersionDemo {

        public static void main(String[] args) {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            builder.setVersion(1.1);
            Gson gson = builder.create();
            User user = new User();
            user.setId(1L);
            user.setName("杨京京");
            user.setAge(18);
            user.setIsMale(true);
            user.setVersion("1.1");
            user.setBirthDay(new Date());
            String jsonString = gson.toJson(user);
            System.out.println(jsonString);
        }
    }


从序列化中排除字段

默认情况下，GSON排除序列化/反序列化过程中的瞬态和静态字段。

GsonBuilder使用序列化/反序列化过程中的excludeFieldsWithModifiers()方法提供对使用特定修饰符排除字段的控制。

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.lang.reflect.Modifier;
    import java.util.Date;

    public class ExcludeFieldsWithModifiersDemo {

        public static void main(String[] args) {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            builder.excludeFieldsWithModifiers(Modifier.TRANSIENT,Modifier.STATIC);
            Gson gson = builder.create();
            User user = new User();
            user.setId(1L);
            user.setName("杨京京");
            user.setAge(18);
            user.setIsMale(true);
            user.setVersion("1.1");
            user.setBirthDay(new Date());
            user.setExcludeTransient("ExcludeTransient");
            String jsonString = gson.toJson(user);
            System.out.println(jsonString);
        }
    }


Gson提供@Expose注解来根据其范围控制类的Json序列化/反序列化。

我们使用GsonBuilder.excludeFieldsWithoutExposeAnnotation()方法来指示只有暴露的变量要被序列化/反序列化。

    package com.demo.gson;

    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.Since;
    import lombok.Data;
    import lombok.ToString;

    import java.io.Serializable;
    import java.util.Date;
    import java.util.List;

    @Data
    @ToString
    public class User implements Serializable {

        private Long id;

        @Expose
        private String name;

        @Expose
        private Integer age;

        private Date birthDay;

        private Boolean isMale;

        private Double balance;

        private String version;

    }


示例代码

    package com.demo.gson;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.lang.reflect.Modifier;
    import java.util.Date;

    public class ExcludeFieldsWithModifiersDemo {

        public static void main(String[] args) {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            builder.excludeFieldsWithModifiers(Modifier.TRANSIENT,Modifier.STATIC);
            Gson gson = builder.create();
            User user = new User();
            user.setId(1L);
            user.setName("杨京京");
            user.setAge(18);
            user.setIsMale(true);
            user.setVersion("1.1");
            user.setBirthDay(new Date());
            String jsonString = gson.toJson(user);
            System.out.println(jsonString);
        }
    }


结果如下

    {
      "name": "杨京京",
      "age": 18
    }


