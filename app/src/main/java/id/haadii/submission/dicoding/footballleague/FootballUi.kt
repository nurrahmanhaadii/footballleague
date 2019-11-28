package id.haadii.submission.dicoding.footballleague

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*


class FootballUi : AnkoComponent<ViewGroup> {
    companion object {
        const val iv_football = 1
        const val tv_football = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                id = iv_football
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            }

            textView {
                id = tv_football
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                textSize = 16f
                textColor = Color.BLACK
                gravity = Gravity.CENTER
            }
        }
    }
}