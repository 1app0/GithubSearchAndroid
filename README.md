# GithubSearchAndroid

Android project for AND1 course. Github search application that uses github api to search for users and fetch data about the searched users repositiories.

MoSCoW requirments:
Must have features:
1. Create an account for this application.
2. Log in to this app.
3. Search for users in github.
4. Display relevant information about the searched user.
5. Display followers for the searched user.
6. Display in a chart most used languages for the searched user.
7. Display in a chart most popular repositories for the searched user.
8. Display stars per language for the searched user.
9. Display most forked repositories for the searched user.

Should have:
1. Star/unstar favourite users.
2. Favourite users should be saved in a remote database.

Could have:
1. Settings page for various settings.

Plan:
- [x] First commit
- [x] Create boilerplate code
- [x] Create layout for the app
- [x] Connect app to Firebase
- [x] Implement login through Firebase
- [x] Implement search user feature
- [x] Fetch repo data for searched user
- [x] Display fetched data
- [x] Implement favourite user through Firebase remote db
- [x] Implement settings page

Requirements that were not met:
1. Implement a settings page - low priority requirment for the initial launch, may be changed later.

During development, it turned out that having too many tabs would clutter the screen and make tab titles unreadable. By unanimous agreement
the development team decided to limit the number of tabs to 4, thus not displaying the following charts:
5. Display followers for the searched user
9. Display most forked repositories for the searched user.
They may be featured as an alternate tab option for future releases.

Requirements that were met:
Must have requirements:
1. Create an account for this application.
2. Log in to this app.
3. Search for users in github.
4. Display relevant information about the searched user.
6. Display in a chart most used languages for the searched user.
7. Display in a chart most popular repositories for the searched user.
8. Display stars per language for the searched user.
Should have requirements:
1. Star/unstar favourite users.
2. Favourite users should be saved in a remote database.