package ca.campbell.layoutprogrammatically

/*
 * This app is the same app created in week2-rw-views, it has exactly
 * the same functionality.
 *
 * See: github week02
 *
 * The difference is that the layout & associated views are created only programmatically.
 * None of the UI is created through xml.
 */
import android.os.Bundle
import android.app.ActionBar.LayoutParams
import android.app.Activity
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private var buttonParams: LinearLayout.LayoutParams? = null
    private var params: LinearLayout.LayoutParams? = null
    private var et: EditText? = null
    private var str: CharSequence? = null
    internal var tvresulthdr: TextView? = null
    internal var tvresult: TextView? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createLayout()
    }

    fun createLayout() {

        // set up the Linear Layout container)
        val ll = LinearLayout(this)
        // specifying vertical orientation
        ll.orientation = LinearLayout.VERTICAL
        // creating LayoutParams
        // public LinearLayout.LayoutParams (int width, int height, float
        // weight)
        params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT)

        // set LinearLayout as a root element of the screen
        ll.layoutParams = params

        val tv = TextView(this)
        tv.setText(R.string.message)
        // default width wrap, height wrap so no params
        ll.addView(tv)

        // width MATCH_PARENT, set before, here for illustration
        params!!.width = LayoutParams.MATCH_PARENT
        params!!.height = LayoutParams.WRAP_CONTENT
        et = EditText(this)
        et!!.setHint(R.string.hint)
        et!!.layoutParams = params
        ll.addView(et)

        val ll2 = LinearLayout(this)
        // same params as EditText
        ll2.layoutParams = params
        ll2.orientation = LinearLayout.HORIZONTAL

        buttonParams = LinearLayout.LayoutParams(0,
                LayoutParams.WRAP_CONTENT, 2.toFloat())
        val bt1 = Button(this)
        bt1.layoutParams = buttonParams
        bt1.setText(R.string.btsubmit)
        ll2.addView(bt1)

        val bt2 = Button(this)
        buttonParams!!.weight = 1.toFloat()
        bt2.layoutParams = buttonParams
        bt2.setText(R.string.btclear)
        ll2.addView(bt2)

        ll.addView(ll2)

        tvresulthdr = TextView(this)
        // params same
        tvresulthdr!!.visibility = TextView.INVISIBLE
        tvresulthdr!!.layoutParams = params
        ll.addView(tvresulthdr)

        tvresult = TextView(this)
        // default width wrap, height wrap
        tvresult!!.visibility = TextView.INVISIBLE
        ll.addView(tvresult)

        // add listeners for on click events
        // button 1
        bt1.setOnClickListener { view -> showData(view) }
        // button 2
        bt2.setOnClickListener { view -> clearData(view) }
        // Use the layout objects
        setContentView(ll)

    }

    // showData() is the method called by the View.OnClickListener()
    fun showData(view: View) {
        // get the references to the view widgets
        // no reference to the header TextView, I don't manipulate it
        // et = (EditText) findViewById(R.id.input);
        // get the data input
        str = et!!.text.toString()

        // tvresulthdr = (TextView) findViewById(R.id.resultheader);
        tvresulthdr!!.visibility = TextView.VISIBLE

        // tvresult = (TextView) findViewById(R.id.result);
        tvresult!!.visibility = TextView.VISIBLE
        tvresult!!.text = str

        // need minimum api 9 for str.isEmpty() :(
        if ((str as String).isEmpty()) {
            tvresulthdr!!.setText(R.string.emptymsg)
            Log.w(TAG, "showData(): no data")
        } else {
            if (str == SECRET) {
                tvresulthdr!!.setText(R.string.successmsg)
                Log.w(TAG, "showData(): guessed correctly")
            } else {
                tvresulthdr!!.setText(R.string.tryagainmsg)
                Log.w(TAG, "showData(): bad guess")
            }
        }
    }

    fun clearData(view: View) {
        if (tvresulthdr != null) {
            tvresulthdr!!.visibility = TextView.INVISIBLE
            et!!.setText("")
            Log.w(TAG, "clearData(): reset fields")
        }
        Log.w(TAG, "clearData(): fields not set yet")
    }

    companion object {
        private val TAG = "RWPROGVIEWS"
        private val SECRET = "guacamole"
    }

}
