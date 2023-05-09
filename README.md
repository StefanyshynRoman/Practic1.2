Compile a jar with maven and run a program that prints json of this type exactly as a jar
{“message”: “Hello <text from external property file, property username=Your name> !”}
Use the jackson-databind library
Add a system option that switches the output to xml/json format.
Connect the LogBack logger and log the output at the performed login level.
Build and run on another computer, another OS (you can have someone from the team available on AWS https://aws.amazon.com/ru/ec2/getting-started/ ) 
as a jar (maven-assembly-plugin) and like fat-jar (maven-shade-plugin)
(Use two maven profiles for the build, either of the two plugins).
