package com.xfq.bottomdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @author QQ:2996681473
 */

object EditDialog {
    private var context: Context? = null
    private var title: String? = null
    private var content: String? = null
    private var button: Boolean = false
    private var cancelAble: Boolean = true
    private var view: View? = null
    private var dialog: BottomSheetDialog? = null

    /**
     * 初始化操作
     * @param context 一般传入一个Activity 如果传别的context大部分情况也没问题的
     * @return EditDialog对象
     */
    fun EditDialog(context: Context): EditDialog {
        this.dialog = BottomSheetDialog(context, R.style.BottomSheetDialog)
        this.context = context
        val constraint = ConstraintLayout(context)
        this.view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_input_dialog, constraint, false)
        return this
    }

    /**
     * 设置标题
     */
    fun setTitle(title: String): EditDialog {
        return if (context == null) {
            EditDialog
        } else {
            this.title = title
            this
        }
    }

    fun setTitle(title: Int): EditDialog {
        return if (context == null) {
            EditDialog
        } else {
            this.title = getResString(title)
            this
        }
    }

    /**
     * 设置按钮
     */
    fun setButton(title: String, onClick: View.OnClickListener): EditDialog {
        return if (context == null) {
            EditDialog
        } else {
            button = true
            view!!.findViewById<Button>(R.id.button).apply {
                text = title
                setOnClickListener(onClick)
            }
            this
        }
    }

    fun setButton(title: Int, onClick: View.OnClickListener): EditDialog {
        return if (context == null) {
            EditDialog
        } else {
            button = true
            view!!.findViewById<Button>(R.id.button1).apply {
                visibility = View.VISIBLE
                text = getResString(title)
                setOnClickListener(onClick)
            }
            this
        }
    }

    /**
     * 是否能取消
     */
    fun setCancelAble(cancelAble: Boolean): EditDialog {
        return if (context == null) {
            EditDialog
        } else {
            this.cancelAble = cancelAble
            this
        }
    }

    /**
     * 获取EditText 一般用在需要自定义EditText时
     */
    fun getEdit(): EditText? {
        return view?.findViewById(R.id.editText)
    }

    /**
     * 获取EditText的文本
     */
    fun getText(): String {
        return this.view?.findViewById<EditText>(R.id.editText)?.text.toString()
    }

    /**
     * 关闭Dialog
     */
    fun close() {
        dialog?.cancel()
    }

    /**
     * 显示Dialog
     */
    fun show(): Boolean {
        return if (dialog == null || context == null || title == null || content === null || view == null || !button) {
            false
        } else {
            dialog!!.setContentView(view!!)
            dialog!!.setCancelable(cancelAble)
            dialog!!.setCanceledOnTouchOutside(cancelAble)
            dialog!!.show()
            dialog!!.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            dialog!!.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                        dialog!!.cancel()
                    }
                }
            })
            true
        }
    }

    /**
     * 获取String资源
     * @param id 资源ID
     * @return 获取到的String
     */
    private fun getResString(id: Int): String {
        return context!!.resources!!.getString(id)
    }
}