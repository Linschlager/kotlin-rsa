# kotlin-rsa
RSA Cryptosystem implementation in Kotlin
You can find the executable JAR-file in [here](/artifacts/rsa-in-kotlin.jar)

## CLI Usage

| Parameter | Type | Description | Format |
| --- | --- | --- | --- |
| --file | String | Absolute Path to input file | CSV or Text
| --public-key | String | Absolute path to public key file | (n,e)
| --private-key | String | Absolute path to private key file | (n,d)
| --encrypt | Switch | Flag to encrypt the input file using the given public key or generating a new random one |
| --decrypt | Switch | Flag to decrypt the input file using the given private key |

## Example
java -jar rsa-in-kotlin.jar --file=input/cipher.txt --private-key=input/sk.txt --decrypt

java -jar rsa-in-kotlin.jar --file=C:\Users\Linus\Desktop\input.txt --encrypt