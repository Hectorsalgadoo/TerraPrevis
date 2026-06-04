package br.com.fiap.terraprevis.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import br.com.fiap.terraprevis.R

@Composable
fun AlertsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.screen_title),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )


        Text(
            text = stringResource(id = R.string.screen_subtitle),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )


        Text(
            text = stringResource(id = R.string.section_demo),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp).align(Alignment.Start)
        )

        TranslationDemoCard(
            satelliteData = "L2A_T23KQS_NDVI < 0.23",
            aiTranslation = "Suas plantas no lado Norte estão perdendo a cor verde saudável por falta de água.",
            actionRecommended = "Ação: Ative a irrigação no quadrante Norte por 40 minutos hoje à tarde."
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = stringResource(id = R.string.section_alerts),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp).align(Alignment.Start)
        )


        Card(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFD32F2F).copy(alpha = 0.12f))
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(text = "Estresse Hídrico Detetado", color = Color(0xFFD32F2F), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Imagens térmicas orbitais revelam queda brusca de umidade no solo.", color = MaterialTheme.colorScheme.onSurface, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun TranslationDemoCard(satelliteData: String, aiTranslation: String, actionRecommended: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.Black.copy(alpha = 0.2f), RoundedCornerShape(6.dp)).padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.telemetry_label),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontFamily = FontFamily.Monospace
                )
                Text(text = satelliteData, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, fontFamily = FontFamily.Monospace)
            }

            Box(modifier = Modifier.padding(vertical = 4.dp).align(Alignment.CenterHorizontally)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f), modifier = Modifier.size(16.dp))
            }

            Text(text = stringResource(id = R.string.ai_translation_label), fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00E676))
            Text(text = aiTranslation, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.padding(top = 2.dp, bottom = 8.dp))

            Box(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), RoundedCornerShape(6.dp)).padding(8.dp)) {
                Text(text = actionRecommended, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}