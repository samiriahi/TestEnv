pipeline {
	agent any 
	
	stages {
		stage (	'Git Check out ' ) {
			steps{
				 git branch : 'main' , url : 'https://github.com/samiriahi/TestEnv.git'			 
				}			
			}
			
			stage (	'Unit testing ' ) {
			steps{
				 sh 'mvn test'  		 
				}
			}	
			
			
				
	}
}