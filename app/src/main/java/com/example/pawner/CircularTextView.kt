package com.example.pawner

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class CircularTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 40f 
        textAlign = Paint.Align.CENTER
    }

    private val path = Path()
    private var text = "UNIRSE A FAMILIA"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (width.coerceAtMost(height) / 2f) * 0.8f

        path.reset()
        // Add a circular path, we will draw the text along this path
        path.addCircle(centerX, centerY, radius, Path.Direction.CW)

        // Draw the text on the path
        // The 0f for hOffset starts the text at the beginning of the path
        // The 0f for vOffset aligns the text baseline with the path.
        // To center the text vertically on the path, you might need to adjust vOffset.
        // For example, vOffset = textPaint.textSize / 2
        canvas.drawTextOnPath(text, path, 0f, textPaint.textSize / 2, textPaint)
    }

    fun setText(newText: String) {
        text = newText
        invalidate() // Redraw the view with the new text
    }
}
