add-type -path Microsoft.WindowsAzure.StorageClient.dll

function download([string]$path, [string]$dest) {
    echo "from $path to $dest"
    md -force $dest
    $name = $path.substring($path.lastindexof('/')+1)
    [Microsoft.WindowsAzure.StorageClient.CloudStorageAccountStorageClientExtensions]::CreateCloudBlobClient(
        [Microsoft.WindowsAzure.CloudStorageAccount]::Parse($env:CONNECTION_STRING)
    ).GetBlobReference($path).DownloadToFile("$dest\$name")
    .\7za x `"$dest\$name`" `-y `-o`"$dest`"
}
download "devoxx/java.zip" "$env:JAVA_PATH\java"
download "devoxx/play.zip" "$env:JAVA_PATH\play"