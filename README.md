# 导入
```gradle
implementation 'com.xfq:bottomDialog:1.0'
```
# 使用
## 提示/确认框示例
```kotlin
import com.xfq.bottomdialog.BottomDialog.createDialog
import com.xfq.bottomdialog.BottomDialog.showDialog

val dialog = createDialog(this)
//                  标题      内容     按钮1   按钮2   按钮3     各按钮点击事件
showDialog(dialog, "提示", "这是示例", "确认", "取消", "关闭", View.OnClickListener{
  dialog.cancel()
  //确认
  
}, View.OnClickListener{
  dialog.cancel()
  //取消
  
}, View.OnClickListener{
  dialog.cancel()
  //关闭
  
}, false)
//是否允许取消（除dialog.cancel()/dialog.dismiss() 不传：有按钮弹窗默认允许、无按钮弹窗默认不允许）

//按钮与点击事件可视情况忽略 支持全部文字参数使用资源ID、支持除“内容”的类型为String外其他文字参数使用资源ID
```
## 带EditText输入框示例
```kotlin
import com.xfq.bottomdialog.BottomDialog.createDialog
import com.xfq.bottomdialog.BottomDialog.showDialog

val dialog = createDialog(this)
//获取View
val view = getView()
val editText = view.findViewById<EditText>(R.id.editText)
editText.hint = "website"
editText.inputType = InputType.TYPE_TEXT_VARIATION_URI
//                       标题                      按钮                 点击事件
showDialog(dialog, R.string.website, view, android.R.string.yes, View.OnClickListener {
  dialog.cancel()
  //按钮
  
}, false)
//是否允许取消（除dialog.cancel()/dialog.dismiss() 不传默认允许）
//支持全部文字参数使用String
```
