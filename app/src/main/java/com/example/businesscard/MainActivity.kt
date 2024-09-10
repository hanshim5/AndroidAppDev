package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardPreview()

                }
            }
        }
    }
}


@Composable
fun CardLogo(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

        // Column to stack Image above CardName
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFd3f8d3)
                )
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(116.dp)
                    .border(BorderStroke(1.dp, Color.Black))
                    .background(Color.DarkGray)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = name,
                fontSize = 42.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                //modifier = Modifier.padding(top = (-8).dp)

                )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,


                color = Color(0xFF004100),
            )
        }
}

@Composable
fun ContactInfo(contact: String, icon: ImageVector, modifier: Modifier = Modifier) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(
                text = contact,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier) {
            CardLogo(name = "Jennifer Doe", title = "Android Developer Extraordinaire")

            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier) {
                ContactInfo(contact = "+00 (00) 000 000", icon = Icons.Default.Call)
                ContactInfo(contact = "@socialmediahandle", icon = Icons.Default.Share)
                ContactInfo(contact = "email@domail.com", icon = Icons.Default.Email)
                Spacer(modifier = Modifier.height(28.dp).padding(12.dp))
            }
        }
    }
}