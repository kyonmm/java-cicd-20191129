# java-cicd-20191129

## setup
### git
```shell script
git clone https://github.com/yourAccount/yourRepository
cd yourRepository
wget ~.zip
unzip ~.zip
rm ~.zip
./gradlew build
git add .
git commit
git push origin master
```
### IntelliJ IDEA
### heroku
```shell script
heroku login
heroku create
heroku stack:set container
git push heroku master
heroku open
```
