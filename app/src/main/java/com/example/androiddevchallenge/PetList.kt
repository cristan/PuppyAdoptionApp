/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalFoundationApi
@Composable
fun PetList(pets: List<Pet>, navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 192.dp),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(pets.size) { petIndex ->
                val petToShow = pets[petIndex]
                Pet(petToShow) {
                    navController.currentBackStackEntry?.arguments?.putParcelable("pet", petToShow)
                    navController.navigate("pet")
                }
            }
        }
    }
}

@Composable
fun Pet(pet: Pet, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(pet.imageRes),
            contentDescription = null,
            modifier = Modifier.clip(shape = RoundedCornerShape(percent = 50)),
        )
        Text(pet.name)
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 400, heightDp = 680)
@Composable
fun PetListPreview() {
    MyTheme {
        PetList(allPets, rememberNavController())
    }
}
