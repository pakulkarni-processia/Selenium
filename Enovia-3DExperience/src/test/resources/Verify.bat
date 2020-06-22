echo on

for /f "tokens=3,2,4 delims=/- " %%x in ("%date%") do set d=%%y%%x%%z
set data=%d%

Echo zipping...

"C:\Program Files\7-Zip\7z.exe" a -tzip "C:\Users\pakulkarni\git\Selenium\Enovia-3DExperience\target\Cucumber-Report\Cucumber_Report_%d%.zip" "C:\Users\pakulkarni\git\Selenium\Enovia-3DExperience\target\Cucumber-Report\cucumber-html-reports"

echo Done!