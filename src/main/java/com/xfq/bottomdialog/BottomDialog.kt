package com.xfq.bottomdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @author QQ:2996681473
 */

object BottomDialog {
    private var context: Context? = null
    private var title: String? = null
    private var content: String? = null
    private var button1: Boolean = false
    private var button2: Boolean = false
    private var button3: Boolean = false
    private var cancelAble: Boolean = true
    private var view: View? = null
    private var dialog: BottomSheetDialog? = null

    /**
     * 初始化操作
     * @param context 一般传入一个Activity 如果传别的context大部分情况也没问题的
     * @return BottomDialog对象
     */
    fun BottomDialog(context: Context): BottomDialog {
        this.dialog = BottomSheetDialog(context, R.style.BottomSheetDialog)
        this.context = context
        val constraint = ConstraintLayout(context)
        this.view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_confirm_dialog, constraint, false)
        return this
    }

    /**
     * 设置标题
     */
    fun setTitle(title: String): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            this.title = title
            this
        }
    }

    fun setTitle(title: Int): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            this.title = getResString(title)
            this
        }
    }

    /**
     * 设置内容
     */
    fun setContent(content: String): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            this.content = content
            this
        }
    }

    fun setContent(content: Int): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            this.content = getResString(content)
            this
        }
    }

    /**
     * 设置按钮
     */
    fun setButton1(title: String, onClick: View.OnClickListener): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            button1 = true
            view!!.findViewById<Button>(R.id.button1).apply {
                visibility = View.VISIBLE
                text = title
                setOnClickListener(onClick)
            }
            this
        }
    }

    fun setButton1(title: Int, onClick: View.OnClickListener): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            button1 = true
            view!!.findViewById<Button>(R.id.button1).apply {
                visibility = View.VISIBLE
                text = getResString(title)
                setOnClickListener(onClick)
            }
            this
        }
    }

    fun setButton2(title: String, onClick: View.OnClickListener): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            button2 = true
            view!!.findViewById<Button>(R.id.button2).apply {
                visibility = View.VISIBLE
                text = title
                setOnClickListener(onClick)
            }
            this
        }
    }

    fun setButton2(title: Int, onClick: View.OnClickListener): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            button2 = true
            view!!.findViewById<Button>(R.id.button2).apply {
                visibility = View.VISIBLE
                text = getResString(title)
                setOnClickListener(onClick)
            }
            this
        }
    }

    fun setButton3(title: String, onClick: View.OnClickListener): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            button3 = true
            view!!.findViewById<Button>(R.id.button3).apply {
                visibility = View.VISIBLE
                text = title
                setOnClickListener(onClick)
            }
            this
        }
    }

    fun setButton3(title: Int, onClick: View.OnClickListener): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            button3 = true
            view!!.findViewById<Button>(R.id.button3).apply {
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
    fun setCancelAble(cancelAble: Boolean): BottomDialog {
        return if (context == null) {
            BottomDialog
        } else {
            this.cancelAble = cancelAble
            this
        }
    }

    /**
     * 关闭Dialog
     */
    fun close() {
        dialog?.cancel()
    }

    /**
     * 显示Dialog 如没有设置Button则会显示一个Button并根据cancelAble设置它的isEnabled属性和点击事件
     */
    fun show(): Boolean {
        return if (dialog == null || context == null || title == null || content === null || view == null) {
            false
        } else {
            if (!button1 && !button2 && !button3) {
                view!!.findViewById<Button>(R.id.button1).apply {
                    visibility = View.VISIBLE
                    text = getResString(android.R.string.cancel)
                    isEnabled = cancelAble
                    if (cancelAble) {
                        setOnClickListener {
                            close()
                        }
                    }
                }
            }
            view!!.findViewById<TextView>(R.id.title).text = title
            view!!.findViewById<TextView>(R.id.content).text = content
            dialog!!.setContentView(view!!)
            dialog!!.setCancelable(cancelAble)
            dialog!!.setCanceledOnTouchOutside(cancelAble)
            dialog!!.show()
            dialog!!.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            dialog!!.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                        close()
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