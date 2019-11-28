package id.haadii.submission.dicoding.footballleague

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val rv_football = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUi().setContentView(this)
    }

    class MainActivityUi : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                recyclerView {
                    id = rv_football
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = FootballAdapter(DataDummy().footballData()) {
                        startActivity<DetailActivity>("football" to it)
                    }
                }
            }
        }
    }
}
