FROM openjdk AS JavaBuild
WORKDIR /PetStoreTestProject
COPY . /PetStoreTestProject
EXPOSE 81
CMD ["javac", "./gradlew", "test"]