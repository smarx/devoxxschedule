cd /d "%~dp0"
powershell -executionpolicy unrestricted ./downloadstuff.ps1
echo y| cacls %JAVA_PATH% /grant everyone:f /t
echo y| cacls . /grant everyone:f /t