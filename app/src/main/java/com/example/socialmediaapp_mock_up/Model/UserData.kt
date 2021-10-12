package com.example.socialmediaapp_mock_up.Model

import android.graphics.drawable.Drawable
import android.net.Uri

class UserData {
    val userList: ArrayList<User> = ArrayList()

    init {
        val user1 = User(
            "Satoshi Nakamoto", "1 hour ago", "https://i.stack.imgur.com/ZME5U.jpg",
            "Bitcoin founder", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );

        val user2 = User(
            "Bill Gates", "Yesterday", "https://postal.ninja/assets/images/48981817022dda35bf548590be816d60-logo-100x100.png",
            "Programming", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );

        val user3 = User(
            "Jeff Bezos", "17 min ago",  "https://qotoqot.com/sad-animations/img/200/silent_tears/silent_tears.png",
            "Chill", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );

        val user4 = User(
            "Elon Musk", "online",  "https://lh3.googleusercontent.com/proxy/Gp-yw3KI5nJhr_fw2rfmhTDnuuPCz32TyH8HUfP4LHSmBBG28403_CYahwS3geRRku7vBnIkCFcJmx4fcbwSNEs6U44zSbmgdg",
            "Market manipulator", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );

        val user5 = User(
            "Carl Johnson (CJ)", "5 years ago",  "https://avatarfiles.alphacoders.com/812/thumb-81215.png",
            "Gangsta", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );


        val user6 = User(
            "Van Gogh", "1 month ago",  "data:image/jpeg;base64,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",
            "UX/UI design", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );

        val user7 = User(
            "Taras Shevchenko", "more than 100 years ago",  "https://kpi.ua/files/images/shevchenko_taras.jpg",
            "Secret", "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!" +
                    "A few words about me! A few words about me! A few words about me! A few words about me!"
        );

        userList.add(user1)
        userList.add(user2)
        userList.add(user3)
        userList.add(user4)
        userList.add(user5)
        userList.add(user6)
        userList.add(user7)
    }
}