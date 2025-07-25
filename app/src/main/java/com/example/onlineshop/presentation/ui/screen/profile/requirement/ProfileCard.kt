package com.example.onlineshop.presentation.ui.screen.profile.requirement

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.R
import com.example.onlineshop.domain.model.User

@Composable
fun ProfileCard(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp)
            )
//            .clip(RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFFFD937F), Color(0xFFE32A0D)),
//                start = Offset(0f, 0f), // Top-left
//                end = Offset.Infinite     // Bottom-right (or custom value)

                    start = Offset.Infinite.copy(x = Float.POSITIVE_INFINITY, y = 0f), // Top-right
                    end = Offset(0f, Float.POSITIVE_INFINITY) // Bottom-left
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                "پروفایل کاربری",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )
                Spacer(Modifier.width(32.dp))
                Box(
                    modifier = Modifier.size(100.dp), // Outer Box: total space allowed
                    contentAlignment = Alignment.Center
                ) {
                    // White circular band
                    CircularProgressRing(progress = 0.75f)

                    // Actual profile image
                    Image(
                        painter = painterResource(user.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp) // slightly smaller than the white band
                            .clip(CircleShape)
                    )
                }
                Spacer(Modifier.width(32.dp))
                Icon(
                    painter = painterResource(R.drawable.camera),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )

            }

            Text(
                user.name,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(user.phone, color = Color.White, fontSize = 18.sp)
            Spacer(Modifier.height(32.dp))
        }
    }
}
@Composable
fun MediumProfileCard(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp)
            )
//            .clip(RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFFFD937F), Color(0xFFE32A0D)),
//                start = Offset(0f, 0f), // Top-left
//                end = Offset.Infinite     // Bottom-right (or custom value)

                    start = Offset.Infinite.copy(x = Float.POSITIVE_INFINITY, y = 0f), // Top-right
                    end = Offset(0f, Float.POSITIVE_INFINITY) // Bottom-left
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                "پروفایل کاربری",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )
                Spacer(Modifier.width(32.dp))
                Box(
                    modifier = Modifier.size(100.dp), // Outer Box: total space allowed
                    contentAlignment = Alignment.Center
                ) {
                    // White circular band
                    CircularProgressRing(progress = 0.75f)

                    // Actual profile image
                    Image(
                        painter = painterResource(user.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp) // slightly smaller than the white band
                            .clip(CircleShape)
                    )
                }
                Spacer(Modifier.width(32.dp))
                Icon(
                    painter = painterResource(R.drawable.camera),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )

            }
        }
    }
}

@Composable
fun SmallProfileCard(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp)
            )
//            .clip(RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFFFD937F), Color(0xFFE32A0D)),
//                start = Offset(0f, 0f), // Top-left
//                end = Offset.Infinite     // Bottom-right (or custom value)

                    start = Offset.Infinite.copy(x = Float.POSITIVE_INFINITY, y = 0f), // Top-right
                    end = Offset(0f, Float.POSITIVE_INFINITY) // Bottom-left
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Row (
            Modifier.padding(vertical = 28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(100.dp), // Outer Box: total space allowed
                contentAlignment = Alignment.Center
            ) {
                // White circular band
                CircularProgressRing(progress = 0.75f)

                // Actual profile image
                Image(
                    painter = painterResource(user.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp) // slightly smaller than the white band
                        .clip(CircleShape)
                )
            }

            Column(Modifier.padding(vertical = 28.dp)) {
                Text(
                    user.name,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))
                Text(user.phone, color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSmallProfile(){
}