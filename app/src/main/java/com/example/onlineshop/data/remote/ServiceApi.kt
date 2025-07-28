package com.example.onlineshop.data.remote

import com.example.onlineshop.R
import com.example.onlineshop.domain.model.Address
import com.example.onlineshop.domain.model.Banner
import com.example.onlineshop.domain.model.Feature
import com.example.onlineshop.domain.model.GroupInfo
import com.example.onlineshop.domain.model.Opinion
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.domain.model.User

fun getBannerContent(): List<Banner> {
    return listOf(
        Banner(
            title = "از ورزشت لذت ببر!",
            image = R.drawable.shirt,
            content = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها ",
        ),
        Banner(
            title = "از ورزشت لذت ببر!",
            image = R.drawable.pants,
            content = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها تولید و عرضه انواع کفش های اسپرت در همه سایز ها",
        ),
        Banner(
            title = "از ورزشت لذت ببر!",
            image = R.drawable.shirt,
            content = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها ",
        ),
        Banner(
            title = "از ورزشت لذت ببر!",
            image = R.drawable.pants,
            content = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها تولید و عرضه انواع کفش های اسپرت در همه سایز ها",
        ),
        Banner(
            title = "از ورزشت لذت ببر!",
            image = R.drawable.shirt,
            content = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها ",
        ),
        Banner(
            title = "از ورزشت لذت ببر!",
            image = R.drawable.pants,
            content = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها تولید و عرضه انواع کفش های اسپرت در همه سایز ها",
        ),
    )
}

object ServiceApi {
    val user= User(
        name = "بهرام افشاری",
        phone = "091756423456",
        image = R.drawable.profile
    )
    val addresses = listOf(
        Address(
            destinationName = "محمد عزیزی",
            destinationAddress = "بیرجند-غفاری 16-پلاک 25",
            zipCode = "9874365374",
            phone = "091111111111111",
            isSelected = true

        ),
        Address(
            destinationName = "الهه لطفی",
            destinationAddress = "بیرجند-غفاری 16-پلاک 25",
            zipCode = "9874365374",
            phone = "091111111111111"
        ),
        Address(
            destinationName = "الهه لطفی",
            destinationAddress = "بیرجند-غفاری 16-پلاک 25",
            zipCode = "9874365374",
            phone = "091111111111111"
        )
    )
    val productList = listOf(
        Product(
            name = "ست سویشرت و شلوار مردانه",
            description = "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n" +
                    "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n",
            price = 198000L,
            image = R.drawable.man6,
            groupTitle = GroupInfo.Man,
            subGroup = GroupInfo.Shirt
        ),
        Product(
            name = "ست سویشرت و شلوار مردانه ست سویشرت و شلوار مردانه",
            description = "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n" +
                    "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n",
            price = 180000L,
            image = R.drawable.man1,
            groupTitle = GroupInfo.Man,
            subGroup = GroupInfo.Shirt
        ),
        Product(
            name = "ست سویشرت و شلوار مردانه",
            description = "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n" +
                    "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n",
            price = 2000000,
            discount = 10,
            image = R.drawable.man2,
            features = listOf(
                Feature(
                    type = "وزن خالص",
                    value = " 340 گرم"
                ),
                Feature(
                    type = "وزن با بسته\u200Cبندی",
                    value = " 400 گرم"
                ),
                Feature(
                    type = "وزن خالص" ,
                    value = " 340 گرم"
                ),
                Feature(
                    type =
                            "وزن با بسته\u200Cبندی",
                    value = " 340 گرم"
                )
            ),
            opinion = listOf(
                Opinion(
                    name = "سعیده زینلی",
                    rate = 3.5,
                    opinion = "متن نظر کاربر در اینجا نوشته می شود",
                ),
                Opinion(
                    name = "الهه لطفی",
                    rate = 4.0,
                    opinion = "عالی بود، پیشنهاد می کنم یبار امتحان کنین :)"
                ),
                Opinion(
                    name = "محنا خلیلی",
                    rate = 3.5,
                    opinion = "امکان سفارش چند رنگ رو دارم؟",
                    hasAnswered = listOf(
                        Opinion(
                            name = "فاطمه خسروی",
                            opinion = "بله با شماره 131545454 ثبت سفارش کنین",
                        ),

                        Opinion(
                            name = "محنا خلیلی",
                            rate = 3.5,
                            opinion = "ممنون از لطفتون",
                        ),
                    )
                )
            ),
            groupTitle = GroupInfo.Man,
            subGroup = GroupInfo.Shirt
        ),
        Product(
            name = "ست سویشرت و شلوار مردانه ست سویشرت و شلوار مردانه",
            description = "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n" +
                    "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n",
            price = 200000L,
            image = R.drawable.man3,
            groupTitle = GroupInfo.Man,
            subGroup = GroupInfo.Shirt
        ),
        Product(
            name = "ست سویشرت و شلوار مردانه ست سویشرت و شلوار مردانه",
            description = "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n" +
                    "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n",
            price = 210000L,
            image = R.drawable.man4,
            groupTitle = GroupInfo.Man,
            subGroup = GroupInfo.Shirt
        ),
        Product(
            name = "ست سویشرت و شلوار مردانه",
            description = "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n" +
                    "**با توجه به تفاوت رنگ\u200Cها در صفحه نمایش دستگاه\u200Cهای مختلف، ممکن است رنگ محصولات در تصویر تا 20٪ با واقعیت متفاوت باشد**دارای 5 رنگ جذاب.تمام نخ پنبه.پارچه پیراهن کشمیر.دم دست و پایین بلوز کشباف.سایز بندی:M تا 4XL\n",
            price = 2000000,
            discount = 10,
            image = R.drawable.man5,
            features = listOf(
                Feature(
                    type = "وزن خالص",
                    value = " 340 گرم"
                ),
                Feature(
                    type = "وزن با بسته\u200Cبندی",
                    value = " 400 گرم"
                ),
                Feature(
                    type = "وزن خالص" ,
                    value = " 340 گرم"
                ),
                Feature(
                    type =
                            "وزن با بسته\u200Cبندی",
                    value = " 340 گرم"
                )
            ),
            opinion = listOf(
                Opinion(
                    name = "سعیده زینلی",
                    rate = 3.5,
                    opinion = "متن نظر کاربر در اینجا نوشته می شود",
                ),
                Opinion(
                    name = "الهه لطفی",
                    rate = 4.0,
                    opinion = "عالی بود، پیشنهاد می کنم یبار امتحان کنین :)"
                ),
                Opinion(
                    name = "محنا خلیلی",
                    rate = 3.5,
                    opinion = "امکان سفارش چند رنگ رو دارم؟",
                    hasAnswered = listOf(
                        Opinion(
                            name = "فاطمه خسروی",
                            opinion = "بله با شماره 131545454 ثبت سفارش کنین",
                        ),

                        Opinion(
                            name = "محنا خلیلی",
                            rate = 3.5,
                            opinion = "ممنون از لطفتون",
                        ),
                    )
                )
            ),
            groupTitle = GroupInfo.Man,
            subGroup = GroupInfo.Shirt
        )
    )
}