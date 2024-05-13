package com.example.petstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petstore.ui.theme.screens.accessories.AccessoriesScreen
import com.example.petstore.ui.theme.screens.birds.BirdsScreen
import com.example.petstore.ui.theme.screens.dashboard.DashboardScreen
import com.example.petstore.ui.theme.screens.dogs.DogsScreen
import com.example.petstore.ui.theme.screens.fish.FishScreen
import com.example.petstore.ui.theme.screens.home.HomeScreen
import com.example.petstore.ui.theme.screens.login.LoginScreen
import com.example.petstore.ui.theme.screens.rabbits.RabbitsScreen
import com.example.petstore.ui.theme.screens.signup.SignupScreen
import com.example.petstore.ui.theme.screens.cats.CatsScreen
import com.example.petstore.ui.theme.screens.feeds.FeedsScreen
import com.example.petstore.ui.theme.screens.splash.SplashScreen
import com.example.petstore.ui.theme.screens.upload.UploadScreen
import com.example.petstore.ui.theme.screens.upload.ViewScreen



@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(DASHBOARD_URL){
            DashboardScreen(navController = navController)
        }
        composable(ACCESSORIES_URL){
            AccessoriesScreen(navController = navController)
        }
        composable(CATS_URL){
           CatsScreen(navController = navController)
        }
        composable(DOGS_URL){
            DogsScreen(navController = navController)
        }
        composable(FISH_URL){
           FishScreen(navController = navController)
        }
        composable(BIRDS_URL){
            BirdsScreen(navController = navController)
        }
        composable(RABBITS_URL){
           RabbitsScreen(navController = navController)
        }
        composable(SPLASH_URL){
            SplashScreen(navController = navController)
        }
        composable(FEED_URL){
            FeedsScreen(navController = navController)
        }
        composable(UPLOAD_URL){
            UploadScreen(navController = navController)
        }
        composable(VIEW_URL){
            ViewScreen(navController = navController)
        }


    }
}



