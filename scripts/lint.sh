#!/bin/bash -e

TOP_LEVEL="$(realpath "$(dirname "${BASH_SOURCE[0]}")/..")"
RELEASE=$(grep LAYERSERIES_COMPAT_ts "${TOP_LEVEL}/conf/layer.conf" | cut -f 2 -d '"')
mapfile -t RECIPE_FILES < <(find "${TOP_LEVEL}" -type f \( -name "*.bb" -o -name "*.bbappend" \))

for f in "${RECIPE_FILES[@]}"; do
  echo "Checking $f"
  case "$f" in
    "${TOP_LEVEL}/recipes-kernel/linux/linux-lts-ts_6.6.y.bb")
      oelint-adv --quiet \
                 --color \
                 --suppress oelint.var.bbclassextend \
                 --suppress oelint.var.suggestedvar.BUGTRACKER \
                 --suppress oelint.var.suggestedvar.CVE_PRODUCT \
                 --suppress oelint.var.suggestedvar.CVE_VERSION \
				 --suppress oelint.vars.mispell.unknown \
                 --release "${RELEASE}" \
                 "$f"
      ;;

    *)
      oelint-adv --quiet \
                 --color \
                 --suppress oelint.var.bbclassextend \
                 --suppress oelint.var.suggestedvar.BUGTRACKER \
                 --suppress oelint.var.suggestedvar.CVE_PRODUCT \
                 --suppress oelint.var.suggestedvar.CVE_VERSION \
                 --release "${RELEASE}" \
                 "$f"
      ;;
  esac
done