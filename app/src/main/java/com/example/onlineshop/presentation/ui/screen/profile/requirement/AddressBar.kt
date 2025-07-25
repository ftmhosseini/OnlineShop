package com.example.onlineshop.presentation.ui.screen.profile.requirement

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlineshop.domain.model.Address

@Composable
fun AddressBar(address: Address) {
    Column(
        Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = if(address.isSelected) Color.Red else Color.White, shape = RoundedCornerShape(8.dp))
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(8.dp))
        Row {
            Text("گیرنده: ", fontWeight = FontWeight.Bold)
            Text(address.destinationName)
        }
        Spacer(Modifier.height(8.dp))
        Row {
            Text("آدرس: ", fontWeight = FontWeight.Bold)
            Text(address.destinationAddress)
        }
        Spacer(Modifier.height(8.dp))
        Row {
            Text("کد پستی: ", fontWeight = FontWeight.Bold)
            Text(address.zipCode)
        }
        Spacer(Modifier.height(8.dp))
        Row {
            Text("شماره همراه: ", fontWeight = FontWeight.Bold)
            Text(address.phone)
        }
        Spacer(Modifier.height(8.dp))
        HorizontalDivider(thickness = 2.dp)
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    onClick = {},
                    selected = address.isSelected,
                    colors = RadioButtonColors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Gray,
                        disabledSelectedColor = Color.Gray,
                        disabledUnselectedColor = Color.Gray
                    )
                )
                Text("آدرس پیش فرض")
            }
            Spacer(Modifier.width(16.dp))
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFCF3EC),
                    contentColor = Color.Red
                )
            ) {
                Text("ویرایش")
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF3F2F1),
                    contentColor = Color.Gray
                )
            ) {
                Text("حذف")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewAddressBar() {
}