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
 * BottomSheetDialog 工具类
 * @author QQ:2996681473
 */

object BottomDialog {
    private var context: Context? = null

    /**
     * 显示一个无按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, cancelAble: Boolean) {
        val constraint = ConstraintLayout(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_confirm_dialog, constraint, false)
        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<TextView>(R.id.content).text = content
        view.findViewById<Button>(R.id.button1).text = getResString(android.R.string.cancel)
        view.findViewById<Button>(R.id.button1).isEnabled = false
        view.findViewById<Button>(R.id.button2).visibility = View.GONE
        view.findViewById<Button>(R.id.button3).visibility = View.GONE
        dialog.setContentView(view)
        dialog.setCancelable(cancelAble)
        dialog.setCanceledOnTouchOutside(cancelAble)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                    dialog.cancel()
                }
            }
        })
    }

    /**
     * 显示一个无按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), getResString(content), cancelAble)
    }

    /**
     * 显示一个无按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), content, cancelAble)
    }

    /**
     * 显示一个无按钮底部弹窗 并不允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String) {
        showDialog(dialog, title, content, false)
    }

    /**
     * 显示一个无按钮底部弹窗 并不允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int) {
        showDialog(dialog, getResString(title), getResString(content), false)
    }

    /**
     * 显示一个无按钮底部弹窗 并不允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String) {
        showDialog(dialog, getResString(title), content, false)
    }

    /**
     * 显示一个单按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮显示的文字
     * @param button1OnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, button1Title: String, button1OnClick: View.OnClickListener, cancelAble: Boolean) {
        val constraint = ConstraintLayout(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_confirm_dialog, constraint, false)
        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<TextView>(R.id.content).text = content
        view.findViewById<Button>(R.id.button1).text = button1Title
        view.findViewById<Button>(R.id.button2).visibility = View.GONE
        view.findViewById<Button>(R.id.button3).visibility = View.GONE
        view.findViewById<Button>(R.id.button1).setOnClickListener(button1OnClick)
        dialog.setContentView(view)
        dialog.setCancelable(cancelAble)
        dialog.setCanceledOnTouchOutside(cancelAble)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                    dialog.cancel()
                }
            }
        })
    }

    /**
     * 显示一个单按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮显示的文字
     * @param button1OnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, button1Title: Int, button1OnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), getResString(content), getResString(button1Title), button1OnClick, cancelAble)
    }

    /**
     * 显示一个单按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮显示的文字
     * @param button1OnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, button1Title: Int, button1OnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), content, getResString(button1Title), button1OnClick, cancelAble)
    }

    /**
     * 显示一个单按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮显示的文字
     * @param button1OnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, button1Title: String, button1OnClick: View.OnClickListener) {
        showDialog(dialog, title, content, button1Title, button1OnClick, true)
    }

    /**
     * 显示一个单按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮显示的文字
     * @param button1OnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, button1Title: Int, button1OnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), getResString(content), getResString(button1Title), button1OnClick, true)
    }

    /**
     * 显示一个单按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮显示的文字
     * @param button1OnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, button1Title: Int, button1OnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), content, getResString(button1Title), button1OnClick, true)
    }

    /**
     * 显示一个双按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, button1Title: String, button2Title: String, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, cancelAble: Boolean) {
        val constraint = ConstraintLayout(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_confirm_dialog, constraint, false)
        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<TextView>(R.id.content).text = content
        view.findViewById<Button>(R.id.button1).text = button1Title
        view.findViewById<Button>(R.id.button2).text = button2Title
        view.findViewById<Button>(R.id.button3).visibility = View.GONE
        view.findViewById<Button>(R.id.button1).setOnClickListener(button1OnClick)
        view.findViewById<Button>(R.id.button2).setOnClickListener(button2OnClick)
        dialog.setContentView(view)
        dialog.setCancelable(cancelAble)
        dialog.setCanceledOnTouchOutside(cancelAble)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                    dialog.cancel()
                }
            }
        })
    }

    /**
     * 显示一个双按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, button1Title: Int, button2Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), getResString(content), getResString(button1Title), getResString(button2Title), button1OnClick, button2OnClick, cancelAble)
    }

    /**
     * 显示一个双按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, button1Title: Int, button2Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), content, getResString(button1Title), getResString(button2Title), button1OnClick, button2OnClick, cancelAble)
    }

    /**
     * 显示一个双按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, button1Title: String, button2Title: String, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener) {
        showDialog(dialog, title, content, button1Title, button2Title, button1OnClick, button2OnClick, true)
    }

    /**
     * 显示一个双按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, button1Title: Int, button2Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), getResString(content), getResString(button1Title), getResString(button2Title), button1OnClick, button2OnClick, true)
    }

    /**
     * 显示一个双按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, button1Title: Int, button2Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), content, getResString(button1Title), getResString(button2Title), button1OnClick, button2OnClick, true)
    }

    /**
     * 显示一个三按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button3Title 按钮3显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param button3OnClick 按钮3点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, button1Title: String, button2Title: String, button3Title: String, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, button3OnClick: View.OnClickListener, cancelAble: Boolean) {
        val constraint = ConstraintLayout(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_confirm_dialog, constraint, false)
        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<TextView>(R.id.content).text = content
        view.findViewById<Button>(R.id.button1).text = button1Title
        view.findViewById<Button>(R.id.button2).text = button2Title
        view.findViewById<Button>(R.id.button3).text = button3Title
        view.findViewById<Button>(R.id.button1).setOnClickListener(button1OnClick)
        view.findViewById<Button>(R.id.button2).setOnClickListener(button2OnClick)
        view.findViewById<Button>(R.id.button3).setOnClickListener(button3OnClick)
        dialog.setContentView(view)
        dialog.setCancelable(cancelAble)
        dialog.setCanceledOnTouchOutside(cancelAble)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                    dialog.cancel()
                }
            }
        })
    }

    /**
     * 显示一个三按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button3Title 按钮3显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param button3OnClick 按钮3点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, button1Title: Int, button2Title: Int, button3Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, button3OnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), getResString(content), getResString(button1Title), getResString(button2Title), getResString(button3Title), button1OnClick, button2OnClick, button3OnClick, cancelAble)
    }

    /**
     * 显示一个三按钮底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button3Title 按钮3显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param button3OnClick 按钮3点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, button1Title: Int, button2Title: Int, button3Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, button3OnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), content, getResString(button1Title), getResString(button2Title), getResString(button3Title), button1OnClick, button2OnClick, button3OnClick, cancelAble)
    }

    /**
     * 显示一个三按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button3Title 按钮3显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param button3OnClick 按钮3点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, content: String, button1Title: String, button2Title: String, button3Title: String, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, button3OnClick: View.OnClickListener) {
        showDialog(dialog, title, content, button1Title, button2Title, button3Title, button1OnClick, button2OnClick, button3OnClick, true)
    }

    /**
     * 显示一个三按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button3Title 按钮3显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param button3OnClick 按钮3点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: Int, button1Title: Int, button2Title: Int, button3Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, button3OnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), getResString(content), getResString(button1Title), getResString(button2Title), getResString(button3Title), button1OnClick, button2OnClick, button3OnClick, true)
    }

    /**
     * 显示一个三按钮底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param content 弹窗内容
     * @param button1Title 按钮1显示的文字
     * @param button2Title 按钮2显示的文字
     * @param button3Title 按钮3显示的文字
     * @param button1OnClick 按钮1点击事件 最好在第一行加入dialog.cancel()
     * @param button2OnClick 按钮2点击事件 最好在第一行加入dialog.cancel()
     * @param button3OnClick 按钮3点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, content: String, button1Title: Int, button2Title: Int, button3Title: Int, button1OnClick: View.OnClickListener, button2OnClick: View.OnClickListener, button3OnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), content, getResString(button1Title), getResString(button2Title), getResString(button3Title), button1OnClick, button2OnClick, button3OnClick, true)
    }

    /**
     * 显示一个带EditText的底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param view 一个View 可以通过getView()获得
     * @param buttonTitle 按钮显示的文字
     * @param buttonOnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, view: View, buttonTitle: String, buttonOnClick: View.OnClickListener, cancelAble: Boolean) {
        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<Button>(R.id.button).text = buttonTitle
        view.findViewById<Button>(R.id.button).setOnClickListener(buttonOnClick)
        dialog.setContentView(view)
        dialog.setCancelable(cancelAble)
        dialog.setCanceledOnTouchOutside(cancelAble)
        dialog.show()
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                    dialog.cancel()
                }
            }
        })
    }

    /**
     * 显示一个带EditText的底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param view 一个View 可以通过getView()获得
     * @param buttonTitle 按钮显示的文字
     * @param buttonOnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, view: View, buttonTitle: Int, buttonOnClick: View.OnClickListener, cancelAble: Boolean) {
        showDialog(dialog, getResString(title), view, getResString(buttonTitle), buttonOnClick, cancelAble)
    }

    /**
     * 显示一个带EditText的底部弹窗 并允许下拉/点击外部取消弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param view 一个View 可以通过getView()获得
     * @param buttonTitle 按钮显示的文字
     * @param buttonOnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     */
    fun showDialog(dialog: BottomSheetDialog, title: String, view: View, buttonTitle: String, buttonOnClick: View.OnClickListener) {
        showDialog(dialog, title, view, buttonTitle, buttonOnClick, false)
    }

    /**
     * 显示一个带EditText的底部弹窗
     * @param dialog 一个BottomSheetDialog 可以通过createDialog(context)获得
     * @param title 弹窗标题
     * @param view 一个View 可以通过getView()获得
     * @param buttonTitle 按钮显示的文字
     * @param buttonOnClick 按钮点击事件 最好在第一行加入dialog.cancel()
     * @param cancelAble 是否能通过下拉/点击外部取消弹窗
     */
    fun showDialog(dialog: BottomSheetDialog, title: Int, view: View, buttonTitle: Int, buttonOnClick: View.OnClickListener) {
        showDialog(dialog, getResString(title), view, getResString(buttonTitle), buttonOnClick, true)
    }

    /**
     * 创建一个Dialog
     * @param context 一个context 最好是一个Activity对象
     * @return Dialog对象
     */
    fun createDialog(context: Context): BottomSheetDialog {
        this.context = context
        return BottomSheetDialog(context, R.style.BottomSheetDialog)
    }

    /**
     * 获取带EditText弹窗的View
     * @return 一个View EditText的id为R.id.editText
     */
    fun getView(): View {
        val constraint = ConstraintLayout(context)
        return LayoutInflater.from(context).inflate(R.layout.bottom_sheet_input_dialog, constraint, false)
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