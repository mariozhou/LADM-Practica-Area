package mx.tecnm.tepic.ladm_u2_pooarea

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var Amazon = Imagen(this,R.drawable.icono4,123f,260f)
    var Twitter = Imagen(this,R.drawable.icono6,366f,666f)
    var text = ""


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        Amazon.pintar(c)
        Twitter.pintar(c)


        p.color = Color.BLUE
        p.textSize = 39f

        c.drawText("Tocaste: ${text}",120f,650f,p)
        invalidate()
    }


    fun area(x:Float,y:Float,x1:Float,y1:Float):Boolean{
        if ((x1>=x &&x1<=(x+165))&&(y1>=y&& y1<=(y+165))){
            return true
        }
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
               if(Amazon.estaEnArea(event.x,event.y)){
                   text = "Amazon"
               } else if(Twitter.estaEnArea(event.x,event.y)){
                   text = "Twitter"
               } else {
                   text = "nada"
               }
            }
        }
        return true
    }
}//lienzo

