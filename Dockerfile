FROM openjdk AS JavaBuild
WORKDIR /PetStoreTestProject
COPY . /PetStoreTestProject
EXPOSE 81
CMD ["exec", "src/test/java/api/testng.xml"]