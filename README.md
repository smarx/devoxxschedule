This is a schedule browser for the Devoxx conference. It's built in [Scala](http://www.scala-lang.org/) with the [Play framework](http://www.playframework.org/) and runs on [Windows Azure](http://windowsazure.com).

The Windows Azure part of the code is based heavily on [packanddeploy](https://github.com/smarx/packanddeploy), a simple scaffolding for packaging a Windows Azure app from the command line.

Usage
=====

1. Edit `ServiceConfiguration.*.cscfg` to reference a valid storage account
that includes a container called `devoxx` with `java.zip` and `play.zip` in it.
These should contain a JDK and the Play framework, respectively. They're
downloaded at runtime and unzipped in Windows Azure.
2. Run `build.cmd & run.cmd` to build and run the application locally. This
will use `ServiceCofiguration.Local.cscfg`, so make sure it's configured
properly. Leave it with just one instance to avoid file contention between
processes.
3. Run `pack.cmd` to output `PackAndRun.cspkg`. That file, along with
`ServiceConfiguration.Cloud.cscfg` is what you need to deploy via the Windows
Azure portal (or with some other tool) to get the app running in the cloud.