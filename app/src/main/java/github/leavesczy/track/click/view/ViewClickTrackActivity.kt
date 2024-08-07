package github.leavesczy.track.click.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import github.leavesczy.track.R

/**
 * @Author: leavesCZY
 * @Github: https://github.com/leavesCZY
 * @Desc:
 */
class ViewClickTrackActivity : AppCompatActivity() {

    private var clickIndex = 1

    @Suppress("ObjectLiteralToLambda")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_click_track)
        title = "ViewClickTrack"
        findViewById<TextView>(R.id.btnObjectUnCheck).setOnClickListener(object :
            View.OnClickListener {
            @UncheckViewOnClick
            override fun onClick(view: View) {
                onClickView()
            }
        })
        findViewById<TextView>(R.id.btnObject).setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                onClickView()
            }
        })
        findViewById<TextView>(R.id.btnLambda).setOnClickListener {
            onClickView()
        }
    }

    fun onClickByXml(view: View) {
        onClickView()
    }

    private fun onClickView() {
        findViewById<TextView>(R.id.tvIndex).text = (clickIndex++).toString()
    }

}