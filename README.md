# meta-ts layer for Yocto

This layer adds machine configurations and extended image configurations to support embeddedTS platforms.

See the BSP respository for more information on building images for supported platforms as well as how to integrate this layer in to customer build processes.

https://github.com/embeddedTS/ts-oe-bsp


## Supported Platforms
This Yocto layer currently provides support for the following embeddedTS platforms:

- TS-4900 (Including all official variants, e.g. TS-TPC-8390-4900, as well as custom applications. Custom baseboards may need kernel recipe changes to build the correct devicetree.)
- TS-7970
- TS-TPC-7990
