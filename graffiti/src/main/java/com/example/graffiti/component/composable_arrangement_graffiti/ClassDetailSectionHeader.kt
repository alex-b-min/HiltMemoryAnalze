package com.example.graffiti.component.composable_arrangement_graffiti

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.graffiti.R

@Composable
fun ArrangementStudyComposable(
    centerImageUrl: String,
    classTitle: String,
    centerName: String,
    instructorName: String,
    classTime: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(358.dp)
                .wrapContentHeight(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(start = 24.dp, end = 20.dp)
                        .padding(vertical = 20.dp),
                ) {

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = centerImageUrl,
                            contentScale = ContentScale.Crop,
                            contentDescription = "업체 이미지",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape),
                            placeholder = painterResource(id = R.drawable.exam),
                            error = painterResource(id = R.drawable.exam)
                        )

                        Column {
                            Text(
                                modifier = Modifier.width(100.dp,),
                                text = classTitle,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                ),
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                modifier = Modifier.width(100.dp,),
                                text = centerName,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                ),
                                color = Color.DarkGray,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = instructorName,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                ),
                                color = Color.DarkGray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(3.dp))

                    Spacer(
                        modifier = Modifier
                            .width(190.dp)
                            .height(1.dp)
                            .background(Color.LightGray)
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = classTime,
                        style = TextStyle(
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp
                        )
                    )

                }

                Spacer(
                    modifier = Modifier
                        .wrapContentHeight()
                        .width(1.dp)
                        .background(Color.DarkGray),
                )

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.CenterEnd,
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "앱 로고 아이콘"
                )
            }
        }
    }
}

@Composable
fun ArrangementStudyComposable2(
    centerImageUrl: String,
    classTitle: String,
    centerName: String,
    instructorName: String,
    classTime: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(358.dp)
                .wrapContentHeight(),
        ) {
            ConstraintLayout(
            ) {
                val (divider, box) = createRefs()

                Spacer(
                    modifier = Modifier
                        .wrapContentHeight()
                        .width(1.dp)
                        .constrainAs(divider) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(box.start)
                        }
                        .background(Color.DarkGray)
                    ,
                )

                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .constrainAs(box) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.exam),
                        contentDescription = "앱 로고 아이콘"
                    )
                }

                // Add remaining components here...
            }
        }
    }
}


@Preview
@Composable fun PreviewArrangementStudyComposable() {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ArrangementStudyComposable(
                centerImageUrl = "https://search.yahoo.com/search?p=praesent",
                classTitle = "verterem",
                centerName = "Erin Holt",
                instructorName = "Maggie James",
                classTime = "dapibus",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    }
}

@Preview
@Composable fun PreviewArrangementStudyComposable2() {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ArrangementStudyComposable2(
                centerImageUrl = "https://search.yahoo.com/search?p=praesent",
                classTitle = "verterem",
                centerName = "Erin Holt",
                instructorName = "Maggie James",
                classTime = "dapibus",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    }
}