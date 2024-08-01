package com.example.newsreaderapp.articlelist.presentation.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.newsreaderapp.articlelist.presentation.util.ContentDescriptions

@Composable
fun LoadingDialog(isLoading: Boolean) {
    if (isLoading) {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(dismissOnClickOutside = false)
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier
                    .padding(10.dp)
                    .semantics {
                        this.contentDescription = ContentDescriptions.LOADING_INDICATOR
                    }
                )
            }
        }
    }

}