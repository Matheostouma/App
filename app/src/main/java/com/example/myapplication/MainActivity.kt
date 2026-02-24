package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsList = listOf(
            NewsItem(
                "New Government Digital Services",
                "The city launches an online portal allowing citizens to access public services and documents digitally.",
                R.drawable.news1
            ),

            NewsItem(
                "Android System Update Released",
                "A new Android update improves battery life, privacy protection, and device performance.",
                R.drawable.news2
            ),

            NewsItem(
                "5G Network Expansion Begins",
                "Telecom companies start upgrading infrastructure to deliver faster mobile internet connectivity nationwide.",
                R.drawable.news3
            ),

            NewsItem(
                "Hospital Introduces Online Appointments",
                "Patients can now book doctor visits and view prescriptions using a new hospital mobile application.",
                R.drawable.news4
            ),

            NewsItem(
                "Fingerprint Login Added to Smartphones",
                "New devices now support biometric authentication for secure and quick phone unlocking.",
                R.drawable.news5
            ),

            NewsItem(
                "Mars Mission Tracking Available",
                "Scientists provide a live tracking map for the ongoing Mars exploration spacecraft mission.",
                R.drawable.news6
            ),

            NewsItem(
                "University Launches Technology Fair",
                "Students showcase innovative mobile apps, AI projects, and robotics at the annual campus expo.",
                R.drawable.news7
            ),

            NewsItem(
                "Accessible Gaming Technology Released",
                "New adaptive controllers help players with disabilities enjoy modern video games comfortably.",
                R.drawable.news8
            )
        )

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsScreen(newsList)
                }
            }
        }
    }
}

@Composable
fun NewsScreen(items: List<NewsItem>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "News",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        items(items) { item ->
            NewsRow(item)
            Divider(modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

@Composable
fun NewsRow(item: NewsItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = "news image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}