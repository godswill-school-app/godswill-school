package com.godswill.school

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { GodsWillApp() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GodsWillApp() {
    val context = LocalContext.current
    val mtnNumber = "0761512976"
    val airtelNumber = "0708367874"
    MaterialTheme {
        Scaffold(topBar = { TopAppBar(title = { Text("God's Will N & P School") }) }) { padding ->
            LazyColumn(modifier = Modifier.padding(padding).padding(16.dp)) {
                item {
                    Text("God's Will Nursery and Primary School", style = MaterialTheme.typography.headlineSmall, color = Color(0xFF0D47A1))
                    Text("Kiburara Trading Center, Burahya County, Kabarole District", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(12.dp))
                    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))) {
                        Column(Modifier.padding(16.dp)) {
                            Text("📍 School Location", style = MaterialTheme.typography.titleMedium)
                            Text("Kiburara Trading Center, Fort Portal - Kasese Road")
                            Spacer(Modifier.height(8.dp))
                            Button(onClick = {
                                val uri = Uri.parse("geo:0,0?q=Kiburara Trading Center Kabarole")
                                context.startActivity(Intent(Intent.ACTION_VIEW, uri))
                            }) { Text("Open in Google Maps / Directions") }
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    Text("⭐ Services Offered", style = MaterialTheme.typography.titleLarge)
                    Text("• Quality Education\n• Lunch & Porridge\n• Guidance & Counselling\n• Christian Foundation")
                    Spacer(Modifier.height(16.dp))
                    Text("📚 Classes Available: Baby Class to P.7", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(16.dp))
                    Text("💰 Fees Per Term", style = MaterialTheme.typography.titleLarge)
                    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))) {
                        Column(Modifier.padding(16.dp)) {
                            Text("Baby - Top: 65,000 UGX")
                            Text("P1 - P3: 85,000 UGX")
                            Text("P4 - P6: 95,000 UGX")
                            Text("P7: 105,000 UGX")
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                    Button(onClick = {
                        val ussd = Uri.parse("tel:*165*1*${mtnNumber}%23")
                        context.startActivity(Intent(Intent.ACTION_DIAL, ussd))
                    }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC400))) {
                        Text("Pay MTN MoMo: $mtnNumber", color = Color.Black)
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = {
                        val ussd = Uri.parse("tel:*185*%23")
                        context.startActivity(Intent(Intent.ACTION_DIAL, ussd))
                    }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                        Text("Pay Airtel: $airtelNumber")
                    }
                }
            }
        }
    }
}
