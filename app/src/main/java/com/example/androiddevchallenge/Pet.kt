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

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

val allPets = listOf(
    Pet("Mary Puppins", R.drawable.doggo01),
    Pet("Little Bow Wow", R.drawable.doggo02),
    Pet("Chew-barka", R.drawable.doggo03),
    Pet("Snoop Dog", R.drawable.doggo04),
    Pet("Notorious D.O.G", R.drawable.doggo05),
    Pet("Dame Barks-a-lot", R.drawable.doggo06),
    Pet("Waldo", R.drawable.doggo07),
    Pet("Catherine Zeta Bones", R.drawable.doggo12),
    Pet("Bingo", R.drawable.doggo08),
    Pet("Droolius Caesar", R.drawable.doggo09),
    Pet("Furdinand", R.drawable.doggo10),
    Pet("Sherlock Bones", R.drawable.doggo11),
)

@Parcelize
data class Pet(
    val name: String,
    @DrawableRes val imageRes: Int
) : Parcelable
