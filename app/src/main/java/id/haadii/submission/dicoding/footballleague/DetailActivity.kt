package id.haadii.submission.dicoding.footballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val iv_detail = 4
        const val tv_name = 5
        const val tv_desc = 6
        var football: Football? = null
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        football = intent.getParcelableExtra<Football>("football")

        if (football != null) {
            DetailActiviyUi().setContentView(this)
        }
    }

    class DetailActiviyUi : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                imageView {
                    id = iv_detail
                    layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent)
                }
                Glide.with(this)
                    .load(football!!.image)
                    .into(imageView())
                textView {
                    id = tv_name
                    text = football!!.name
                }
                textView {
                    id = tv_desc
                    text = football!!.description
                }
            }
        }
    }
}
