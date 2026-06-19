package com.example.myapplication

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.ButtonDefaults
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        val horaActual = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

        provideContent {
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(ColorProvider(Color(0xFFE3F2FD)))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Estado de la app",
                    style = TextStyle(
                        color = ColorProvider(Color(0xFF0D47A1)),
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = GlanceModifier.padding(bottom = 6.dp)
                )

                Text(
                    text = "App funcionando correctamente",
                    style = TextStyle(
                        color = ColorProvider(Color(0xFF1565C0))
                    ),
                    modifier = GlanceModifier.padding(bottom = 6.dp)
                )

                Text(
                    text = "Última actualización: $horaActual",
                    style = TextStyle(
                        color = ColorProvider(Color(0xFF333333))
                    ),
                    modifier = GlanceModifier.padding(bottom = 6.dp)
                )

                Text(
                    text = "Widget activo en pantalla principal",
                    style = TextStyle(
                        color = ColorProvider(Color(0xFF333333))
                    ),
                    modifier = GlanceModifier.padding(bottom = 12.dp)
                )

                Button(
                    text = "Ver detalles",
                    onClick = actionStartActivity<SecondActivity>(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = ColorProvider(Color(0xFF1976D2)),
                        contentColor = ColorProvider(Color.White)
                    )
                )
            }
        }
    }
}