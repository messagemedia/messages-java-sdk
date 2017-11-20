node {
    stage 'Checkout' 
        checkout scm 
    
    stage 'Build' 
        bat 'mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V' 
        stage 'Test' 
        bat 'mvn test' 
    }