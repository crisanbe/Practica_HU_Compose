package com.sistecredito.auth.login.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sistecredito.auth.character.presentation.components.CharacterListItem
import com.sistecredito.auth.login.presentation.viewmodel.ListaClienteViewModel
import com.sistecredito.auth.login.presentation.viewmodel.LogInViewModel

@Composable
fun ListaClientePage(
    navController: NavController,
    viewModel: ListaClienteViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }


    Box(modifier = Modifier.fillMaxSize()){
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if(state?.token!= null){
            val tokenaux = state.token.accessToken
            Text(text = "El token que llega es ($tokenaux)")
        }
    }

    /*Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .padding(10.dp)
        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                fontSize = 30.sp
            )
            Text(
                text = "Please sign in to continue.",
                color = Color.Gray,
                style = TextStyle(
                    letterSpacing = 1.sp
                ),
                fontSize = 20.sp
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .padding(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {//CAMBIEN CON UN CLICK SI EL PASWORD ES IGUAL O DIFERENTE VALOR NDE PASSWORD
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            /*Icon(
                                painter = painterResource(),
                                tint = if (passwordVisibility.value) primaryColor else Color.Black,
                                contentDescription = null
                            )*/
                        }
                    },
                    label = { Text(text = "") },
                    placeholder = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                )


                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        trailingIcon = {
                            IconButton(onClick = {//CAMBIEN CON UN CLICK SI EL PASWORD ES IGUAL O DIFERENTE VALOR NDE PASSWORD
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                /*Icon(
                                    painter = painterResource(id = com.example.logincompose.R.drawable.password_eye),
                                    tint = if (passwordVisibility.value) primaryColor else Color.Black,
                                    contentDescription = null
                                )*/
                            }
                        },
                        label = { Text(text = "") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None//SI SE ESCRIBE Y SE DA CLICK EN EL ICONO MUESTRELO
                        else PasswordVisualTransformation(),// SI NO OCULTEMELO
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)

                    )
                }

                //colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Brush.horizontalGradient()),
                //BOTON LOGIN
                Spacer(
                    modifier = Modifier
                        .padding(20.dp)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color.Magenta,
                                    Color.Magenta,
                                    Color.White
                                )
                            )
                        )
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(
                        text = "LOGIN",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            }

        }


    }*/

}


















