# 导入
```gradle
implementation 'com.xfq:bottomDialog:1.1'
```
你可能还需要导入其他依赖 请自行根据`BottomDialog.kt`的缺库报错信息进行导入
# 使用
## 提示/确认框示例
```kotlin
BottomDialog(this).apply {
    setButton1("按钮1") {
        close()
    }
    setButton2(R.string.button_2) {
        //按钮2
    }
    setButton3("") {
        //按钮3
    }
    setTitle("标题")
    setContent(R.string.app_name)
    show()
}
```
## 带EditText输入框示例
```kotlin
EditDialog(this).apply {
    setButton("按钮1") {
        close()
        getText() //有返回值 为EditText的文本：String
    }
    setTitle("标题")
    setContent(R.string.app_name)
    show()
}
```
## Java使用指导
```java
BottomDialog(this).setTitle("title").setContent("content").show()
```
# 注意事项
如果直接调用`setXXX`方法（判定：实例的context是否已被赋值 具体可以打开源码查看）只会返回一个空的BottomDialog或EditDialog对象