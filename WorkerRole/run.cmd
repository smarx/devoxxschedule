cd /d "%~dp0"
set JAVA_HOME=%JAVA_PATH%java
set PATH=%PATH%;%JAVA_PATH%play
call play dependencies app -Duser.home=%CD%\home >> deps.txt 2>>deps.err
play run app --%%prod --http.port=%PORT% -Dhttp.address=%ADDRESS% -Duser.home=%CD%\home >> log.txt 2>> log.err